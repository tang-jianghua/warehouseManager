package com.jianghua.warehousemanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TGoods;
import com.jianghua.warehousemanager.enums.GoodsStateEnum;
import com.jianghua.warehousemanager.mapper.TGoodsMapper;
import com.jianghua.warehousemanager.service.GoodsService;
import com.jianghua.warehousemanager.util.ResponseUtil;
import com.jianghua.warehousemanager.util.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	TGoodsMapper goodsMapper;

	@Override
	public PageInfo<TGoods> getGoods(Map param) {
		int pageNum = param.containsKey("pageIndex") ? Integer.valueOf(param.get("pageIndex").toString()) : 1;
		PageHelper.startPage(pageNum, SysConstants.PAGE_SIZE);
		List<TGoods> list = goodsMapper.selectByMap(param);
		return new PageInfo<>(list);
	}

	@Override
	@Transactional
	public Map addGoods(TGoods tGoods) {
		final String BUSINUSS_NAME = "添加商品";
		TGoods param = new TGoods();
		param.setGoodsName(tGoods.getGoodsName());
		param.setModel(tGoods.getModel());
		param.setState(GoodsStateEnum.NORMAL.getCode());
		List<TGoods> list = goodsMapper.select(param);
		if(!list.isEmpty()){
			return ResponseUtil.fail(BUSINUSS_NAME,"商品已存在");
		}
		tGoods.setCreateTime(new Date());
		tGoods.setState(GoodsStateEnum.NORMAL.getCode());
		tGoods.setStock(0);
		tGoods.setTotalPrice(0);
		if(tGoods.getPrice()==null){
			tGoods.setPrice(0);
		}else{
			tGoods.setPrice(tGoods.getPrice()*100);
		}
		goodsMapper.insertSelective(tGoods);
		return ResponseUtil.success(BUSINUSS_NAME);
	}

	@Override
	public List<TGoods> selectAll() {
		TGoods goods = new TGoods();
		goods.setState(GoodsStateEnum.NORMAL.getCode());
		return goodsMapper.select(goods);
	}

	@Override
	public Boolean remove(TGoods tGoods) {
		tGoods.setState(GoodsStateEnum.REMOVED.getCode());
		return goodsMapper.updateByPrimaryKeySelective(tGoods)>0;
	}
}
