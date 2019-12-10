package com.jianghua.warehousemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TGoods;
import com.jianghua.warehousemanager.entity.TOrder;
import com.jianghua.warehousemanager.enums.OrderStateEnum;
import com.jianghua.warehousemanager.mapper.TGoodsMapper;
import com.jianghua.warehousemanager.mapper.TOrderMapper;
import com.jianghua.warehousemanager.service.OrderService;
import com.jianghua.warehousemanager.util.DateUtils;
import com.jianghua.warehousemanager.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	TGoodsMapper goodsMapper;
	@Autowired
	TOrderMapper orderMapper;

	@Override
	public PageInfo<Map> getOrders(Map param) {
		int pageNum = param.containsKey("pageIndex") ? Integer.valueOf(param.get("pageIndex").toString()) : 1;
		if(param.get("startTime") !=null && !param.get("startTime").equals("")){
			Date startTime = DateUtils.parseDefaultDateBegin(param.get("startTime").toString());
			param.put("start",startTime);
		}
		if(param.get("endTime") !=null && !param.get("endTime").equals("")){
			Date startTime = DateUtils.parseDefaultDateEnd(param.get("endTime").toString());
			param.put("end",startTime);
		}
		PageHelper.startPage(pageNum, SysConstants.PAGE_SIZE);
		List<Map> list = orderMapper.selectByMap(param);
		return new PageInfo<>(list);
	}

	@Override
	@Transactional
	public Boolean removeOrder(Integer orderId,Integer goodsId) {
		TOrder tOrder = new TOrder();
		tOrder.setId(orderId);
		tOrder.setState(OrderStateEnum.REMOVED.getCode());
		orderMapper.updateByPrimaryKeySelective(tOrder);
		TGoods goods = new TGoods();
		goods.setId(goodsId);
		goods.setUpdateTime(new Date());
		goodsMapper.updateGoodsStock(goods);
		return true;
	}

	@Override
	@Transactional
	public Boolean addOrder(TOrder order) {
		order.setState(OrderStateEnum.NORMAL.getCode());
		order.setCreateTime(new Date());
		order.setPrice(order.getPrice());
		order.setTotalPrice(order.getNum()*order.getPrice());
		orderMapper.insertSelective(order);
		TGoods goods = new TGoods();
		goods.setId(order.getGoodsId());
		goods.setUpdateTime(new Date());
		goods.setPrice(order.getPrice());
		goodsMapper.updateGoodsStock(goods);
		return true;
	}
}
