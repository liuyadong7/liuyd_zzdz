package com.lyd.customer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyd.customer.dao.CustomerMapper;
import com.lyd.customer.pojo.Customer;
import com.lyd.customer.service.ICustomerService;
import com.lyd.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>  </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 14:07
 **/
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param customerDTO 顾客信息DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:58
     */
    @Transactional
    @Override
    public boolean addCustomerInfo(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setAddress(customerDTO.getAddress());
        customer.setName(customerDTO.getName());
        return this.save(customer);
    }
}