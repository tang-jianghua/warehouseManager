package com.jianghua.warehousemanager.service;

import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TGoods;

import java.util.List;
import java.util.Map;

public interface GoodsService {

	PageInfo<TGoods> getGoods(Map param);

	List<TGoods> selectAll();

	Map addGoods(TGoods tGoods);

	Boolean remove(TGoods tGoods);
}
