package com.lyd.customer.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p> 顾客信息 </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 11:21
 **/
@Data
@TableName("xa_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -5249863907179808308L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 顾客姓名
     */
    private String name;
    /**
     * 地址名称
     */
    private String address;
}