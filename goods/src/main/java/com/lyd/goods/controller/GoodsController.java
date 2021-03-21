package com.lyd.goods.controller;

import com.lyd.api.IGoodsClient;
import com.lyd.dto.GoodsDTO;
import com.lyd.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 商品信息的controller </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 09:37
 **/
@RestController
public class GoodsController implements IGoodsClient {

    /**
     * 商品的service
     */
    @Autowired
    private IGoodsService goodsService;

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param goodsDTO 商品的参数DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:37
     */
    @Override
    public boolean addGoodsInfo(GoodsDTO goodsDTO) {
        return goodsService.addGoodsInfo(goodsDTO);
    }
}
