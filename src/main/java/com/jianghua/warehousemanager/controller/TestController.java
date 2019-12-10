package com.jianghua.warehousemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

	@RequestMapping("/test")
	public String freemarker(Model model){
		model.addAttribute("name", "Joe");
		model.addAttribute("sex", 1);    //sex:性别，1：男；0：女；

		// 模拟数据
		List<Map<String, Object>> friends = new ArrayList<>();
		Map<String, Object> friend = new HashMap<>();
		friend.put("name", "xbq");
		friend.put("age", 22);
		friends.add(friend);
		friend = new HashMap<>();
		friend.put("name", "July");
		friend.put("age", 18);
		friends.add(friend);
		model.addAttribute("friends",friends);
		return "test";
	}

	@RequestMapping("/")
	public String index(Model model){
		return "index";
	}
	@RequestMapping("/toLogin")
	public String toLogin(Model model){
		return "login";
	}

}
