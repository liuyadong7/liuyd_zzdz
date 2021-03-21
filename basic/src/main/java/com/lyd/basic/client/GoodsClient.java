package com.lyd.basic.client;

import com.lyd.api.IGoodsClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:25
 **/
@Component
@FeignClient(name = "goods", url = "http://localhost:8090")
public interface GoodsClient extends IGoodsClient {
}
