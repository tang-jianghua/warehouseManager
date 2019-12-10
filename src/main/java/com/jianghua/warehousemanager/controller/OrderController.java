package com.jianghua.warehousemanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TOrder;
import com.jianghua.warehousemanager.enums.OrderStateEnum;
import com.jianghua.warehousemanager.service.OrderService;
import com.jianghua.warehousemanager.util.ResponseUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/table")
	public String orderTable(@RequestParam Map<String,Object> param, Model model){
		PageInfo<Map> pageInfo = orderService.getOrders(param);
		model.addAttribute("pageIndex",pageInfo.getPageNum());
		model.addAttribute("totalRow",pageInfo.getTotal());
		model.addAttribute("totalPage",pageInfo.getPages()==0? 1:pageInfo.getPages());
		model.addAttribute("pageNum",pageInfo.getPageSize());
		model.addAttribute("orderList",pageInfo.getList());
		return "order/table";
	}

	@PostMapping("/remove")
	@ResponseBody
	public String remove(@RequestBody JSONObject param){
		orderService.removeOrder(param.getInteger("id"),param.getInteger("goodsId"));
		return "success";
	}
	@RequestMapping("/list")
	public String orderlist(Model model){
		return "order/list";
	}

	@PostMapping("/add")
	@ResponseBody
	public Map orderlist(@RequestBody TOrder order){
		orderService.addOrder(order);
		return ResponseUtil.success("");
	}
}
