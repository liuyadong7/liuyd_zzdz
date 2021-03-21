package com.lyd.api;

import com.lyd.dto.GoodsDTO;
import com.lyd.dto.TradeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p> 商品交易的接口 </p>
 *
 * @author LiuYaDong
 * @since 2021-03-17 23:16
 **/
@RequestMapping(value = "/goods-client")
public interface IGoodsClient {

    /**
     * <p> 增加产品信息 </p>
     *
     * @param goodsDTO 交易参数DTO
     * @return boolean
     * @author gaochenglong
     * @since 2021/2/26 9:17
     */
    @PostMapping(value = "/goods")
    boolean addGoodsInfo(@RequestBody GoodsDTO goodsDTO);
}
