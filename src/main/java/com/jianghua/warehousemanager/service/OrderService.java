package com.jianghua.warehousemanager.service;

import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TOrder;

import java.util.Map;

public interface OrderService {

	PageInfo<Map> getOrders(Map param);

	Boolean removeOrder(Integer orderId,Integer goodsId);

	Boolean addOrder(TOrder order);
}
