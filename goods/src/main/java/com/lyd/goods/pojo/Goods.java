package com.lyd.goods.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p> 商品信息 </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 11:21
 **/
@Data
@TableName("xa_goods")
public class Goods implements Serializable {

    private static final long serialVersionUID = -5249863907179808308L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 商品名
     */
    private String goods;
    /**
     * 数量
     */
    private Integer quantity;
    /**
     * 客户ID
     */
    private Long customerId;
}