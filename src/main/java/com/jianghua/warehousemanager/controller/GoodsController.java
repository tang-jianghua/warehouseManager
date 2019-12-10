package com.jianghua.warehousemanager.controller;

import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.entity.TGoods;
import com.jianghua.warehousemanager.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@Autowired
	GoodsService goodsService;

	@RequestMapping("/add")
	@ResponseBody
	public Map add(@RequestBody TGoods goods){
		return goodsService.addGoods(goods);
	}
	@RequestMapping("/table")
	public String warehouseTable(@RequestParam Map<String,Object> param, Model model){
		PageInfo<TGoods> pageInfo = goodsService.getGoods(param);
		model.addAttribute("pageIndex",pageInfo.getPageNum());
		model.addAttribute("totalRow",pageInfo.getTotal());
		model.addAttribute("totalPage",pageInfo.getPages()==0? 1:pageInfo.getPages());
		model.addAttribute("pageNum",pageInfo.getPageSize());
		model.addAttribute("goodsList",pageInfo.getList());
		return "warehousemanager/table";
	}
	@RequestMapping("/list")
	public String warehouselist(Model model){
		return "warehousemanager/list";
	}

	@ResponseBody
	@RequestMapping("select")
	public Map select(){
		List<TGoods> tGoods = goodsService.selectAll();
		Map map = new HashMap();
		map.put("value",tGoods);
		return map;
	}

	@PostMapping("/remove")
	@ResponseBody
	public String remove(@RequestBody TGoods param){
		goodsService.remove(param);
		return "success";
	}

}
