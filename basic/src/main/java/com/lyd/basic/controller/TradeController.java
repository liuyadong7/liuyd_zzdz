package com.lyd.basic.controller;

import com.lyd.basic.bus.TradeBus;
import com.lyd.dto.TradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.XAConnection;

/**
 * <p> 交易相关Controller </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:34
 **/
@RestController
@RequestMapping(path = "/trade")
public class TradeController {

    /**
     * 交易相关的Bus
     */
    @Autowired
    private TradeBus tradeBus;

    /**
     * <p> 增加顾客和商品信息 </p>
     *
     * @param tradeDTO 交易相关
     * @return boolean
     * @author liuyadong
     * @since 2021/3/17 23:37
     */
    @PostMapping(value = "/trade")
    public boolean addTrade(@RequestBody TradeDTO tradeDTO) {
        return tradeBus.addTrade(tradeDTO);
    }
}
