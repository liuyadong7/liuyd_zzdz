package com.lyd.basic.client;

import com.lyd.api.ICustomerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:25
 **/
@Component
@FeignClient(name = "customer", url = "http://localhost:8080")
public interface CustomerClient extends ICustomerClient {
}
