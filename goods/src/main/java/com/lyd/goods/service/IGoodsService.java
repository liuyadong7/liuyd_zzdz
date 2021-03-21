package com.lyd.goods.service;

import com.lyd.dto.GoodsDTO;

/**
 * <p>  </p>
 *
 * @author liuyadong
 * @desc
 * @since 2021/2/23 14:06
 */
public interface IGoodsService {

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param goodsDTO 商品的参数DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:50
     */
    boolean addGoodsInfo(GoodsDTO goodsDTO);
}
