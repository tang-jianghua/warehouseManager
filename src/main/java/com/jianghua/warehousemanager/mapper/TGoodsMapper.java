package com.jianghua.warehousemanager.mapper;

import com.jianghua.warehousemanager.common.WareBaseMapper;
import com.jianghua.warehousemanager.entity.TGoods;

import java.util.List;
import java.util.Map;

public interface TGoodsMapper extends WareBaseMapper<TGoods> {

	List<TGoods> selectByMap(Map param);

	int updateGoodsStock(TGoods tGoods);
}