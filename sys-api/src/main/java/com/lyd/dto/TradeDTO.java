package com.lyd.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p> 交易参数DTO </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:18
 **/
@Data
public class TradeDTO implements Serializable {

    private static final long serialVersionUID = -5249863902229808308L;

    /**
     * 顾客姓名
     */
    private String name;
    /**
     * 地址名称
     */
    private String address;
    /**
     * 商品名
     */
    private String goods;
    /**
     * 数量
     */
    private Integer quantity;
}
