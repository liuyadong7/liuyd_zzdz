package com.lyd.basic.bus;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.lyd.basic.client.CustomerClient;
import com.lyd.basic.client.GoodsClient;
import com.lyd.dto.CustomerDTO;
import com.lyd.dto.GoodsDTO;
import com.lyd.dto.TradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>  </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:35
 **/
@Service
public class TradeBus {

    /**
     * 顾客的client
     */
    @Autowired
    private CustomerClient customerClient;

    /**
     * 商品的client
     */
    @Autowired
    private GoodsClient goodsClient;


    /**
     * <p> 增加顾客和商品信息 </p>
     *
     * @param tradeDTO 交易参数DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/17 23:38
     */
    public boolean addTrade(TradeDTO tradeDTO) {
        // 处理顾客信息
        Long customerId = IdWorker.getId();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(tradeDTO.getName());
        customerDTO.setAddress(tradeDTO.getAddress());
        customerDTO.setId(customerId);
        customerClient.addCustomerInfo(customerDTO);
        // 处理商品信息
        Long goodsId = IdWorker.getId();
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goodsId);
        goodsDTO.setGoods(tradeDTO.getGoods());
        goodsDTO.setQuantity(tradeDTO.getQuantity());
        goodsDTO.setCustomerId(customerId);
        goodsClient.addGoodsInfo(goodsDTO);
        return true;
    }
}
