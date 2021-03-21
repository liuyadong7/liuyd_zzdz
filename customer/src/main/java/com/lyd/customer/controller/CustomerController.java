package com.lyd.customer.controller;

import com.lyd.api.ICustomerClient;
import com.lyd.customer.service.ICustomerService;
import com.lyd.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 新增顾客信息 </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 09:35
 **/
@RestController
public class CustomerController implements ICustomerClient {

    /**
     * 顾客的service
     */
    @Autowired
    private ICustomerService customerService;

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param customerDTO 顾客信息DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:36
     */
    @Override
    public boolean addCustomerInfo(CustomerDTO customerDTO) {
        return customerService.addCustomerInfo(customerDTO);
    }
}
