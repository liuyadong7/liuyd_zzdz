package com.lyd.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyd.dto.GoodsDTO;
import com.lyd.goods.dao.GoodsMapper;
import com.lyd.goods.pojo.Goods;
import com.lyd.goods.service.IGoodsService;
import org.springframework.stereotype.Service;

/**
 * <p> 添加商品信息 </p>
 *
 * @author LiuYaDong
 * @since 2021-02-23 14:07
 **/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    /**
     * <p> 新增顾客信息 </p>
     *
     * @param goodsDTO 商品的参数DTO
     * @return boolean
     * @author liuyadong
     * @since 2021/3/19 9:50
     */
    @Override
    public boolean addGoodsInfo(GoodsDTO goodsDTO) {
        Goods goods = new Goods();
        goods.setId(goodsDTO.getId());
        goods.setQuantity(goodsDTO.getQuantity());
        goods.setGoods(goodsDTO.getGoods());
        goods.setCustomerId(goodsDTO.getCustomerId());
        return this.save(goods);
    }
}