package com.lyd.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p> 顾客信息DTO </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 11:21
 **/
@Data
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = -5249863907179808308L;

    /**
     * 主键
     */
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