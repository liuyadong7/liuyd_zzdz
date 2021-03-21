package com.lyd.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p> 商品信息DTO </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 11:21
 **/
@Data
public class GoodsDTO implements Serializable {

    private static final long serialVersionUID = -5249863907179808308L;

    /**
     * 主键
     */
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