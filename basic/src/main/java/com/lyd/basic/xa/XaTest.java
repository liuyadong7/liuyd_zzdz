package com.lyd.basic.xa;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.MysqlXAConnection;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

/**
 * <p> XA的测试DEMO </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 22:44
 **/
public class XaTest {
    public static void main(String[] args) throws Exception {

        // 是否开启日志
        boolean logXaCommands = true;

        // 获取liuyd_db库的RM（ap做的事情）
        Connection liuydDbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyd_db?serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "root");
        XAConnection lydConn = new MysqlXAConnection((JdbcConnection) liuydDbConn, logXaCommands);
        XAResource lydRm = lydConn.getXAResource();
        // 获取liuyd_db2的RM
        Connection liuydDbConn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/liuyd_db2?serverTimezone=UTC&characterEncoding=UTF-8&useUnicode=true&useSSL=false", "root", "root");
        XAConnection lydConn2 = new MysqlXAConnection((JdbcConnection) liuydDbConn2, logXaCommands);
        XAResource lydRm2 = lydConn2.getXAResource();


        // XA 事务开始了
        // 全局事务
        byte[] globalId = UUID.randomUUID().toString().getBytes();
        // 就一个标识
        int formatId = 1;

        // 添加顾客的分支事务
        byte[] customerBqual = UUID.randomUUID().toString().getBytes();

        Xid xid = new MysqlXid(globalId, customerBqual, formatId);

        // 添加商品的分支事务
        byte[] goodsBqual = UUID.randomUUID().toString().getBytes();

        Xid xid2 = new MysqlXid(globalId, goodsBqual, formatId);

        Long customerId = IdWorker.getId();

        try {
            // 添加顾客开始 此时状态：ACTIVE
            lydRm.start(xid, XAResource.TMNOFLAGS);
            // 模拟业务
            String sql =
                    "INSERT INTO xa_customer ( id, `name`, address )  VALUES ( " + customerId + ", '李四', '高新区');";
            PreparedStatement ps1 = liuydDbConn.prepareStatement(sql);
            ps1.execute();
            // 顾客 XA 事务 此时状态：IDLE（闲置）

            // 商品分支事务开始
            Long goodsId = IdWorker.getId();
            lydRm2.start(xid2, XAResource.TMNOFLAGS);
            // 模拟业务
            String sql1 = "INSERT INTO xa_goods ( id, goods, quantity, customer_id ) VALUES ( " + goodsId + ", '笔记本', 10, " + customerId + " );";
            PreparedStatement ps2 = liuydDbConn2.prepareStatement(sql1);
            ps2.execute();
            lydRm2.end(xid2, XAResource.TMSUCCESS);


            // 第一阶段：准备提交
            int rm1_prepare = lydRm.prepare(xid);
            int rm2_prepare = lydRm2.prepare(xid2);

            //  XA 事务 此时状态：PREPARED
            // 第二阶段：TM 根据第一阶段的情况决定是提交还是回滚

            //TM判断有2个事务分支，所以不能优化为一阶段提交
            boolean onePhase = false;
            if (rm1_prepare == XAResource.XA_OK && rm2_prepare == XAResource.XA_OK) {
                lydRm.commit(xid, onePhase);
                lydRm2.commit(xid2, onePhase);
            } else {
                lydRm.rollback(xid);
                lydRm2.rollback(xid2);
            }

        } catch (Exception e) {
            // 出现异常，回滚
            lydRm.rollback(xid);
            lydRm2.rollback(xid2);
            e.printStackTrace();
        }
    }
}