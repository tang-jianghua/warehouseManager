package com.jianghua.warehousemanager.mapper;

import com.jianghua.warehousemanager.common.WareBaseMapper;
import com.jianghua.warehousemanager.entity.TOrder;

import java.util.List;
import java.util.Map;

public interface TOrderMapper extends WareBaseMapper<TOrder> {

	List<Map> selectByMap(Map param);
}