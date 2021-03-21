package com.lyd.api;

import com.lyd.dto.CustomerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p> 商品交易的接口 </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:16
 **/
@RequestMapping(value = "/customer-client")
public interface ICustomerClient {

    /**
     * <p> 增加交易信息 </p>
     *
     * @param customerDTO 顾客DTO
     * @return boolean
     * @author gaochenglong
     * @since 2021/2/26 9:17
     */
    @PostMapping(value = "/customer")
    boolean addCustomerInfo(@RequestBody CustomerDTO customerDTO);
}
