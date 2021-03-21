package com.lyd.customer.service;

import com.lyd.dto.CustomerDTO;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @desc
 * @since 2021/2/23 14:06
 */
public interface ICustomerService {

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param customerDTO 顾客信息DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:57
     */
    boolean addCustomerInfo(CustomerDTO customerDTO);
}
