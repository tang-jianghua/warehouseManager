package com.jianghua.warehousemanager.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jianghua.warehousemanager.util.UserContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
	private  Logger log = LoggerFactory.getLogger(LoginController.class);

	@PostMapping(value = "/login")
	public String login(HttpServletRequest request, @RequestParam Map param) {
		final String BUSINESS_NAME = "【登录请求】";
		log.info(BUSINESS_NAME+"------开始");
		log.info(BUSINESS_NAME+"------参数："+ JSON.toJSONString(param));
		try {
			HttpSession session = request.getSession();
			String account = param.get("account").toString().trim();
			String password = param.get("password").toString().trim();
			// 移除已经使用过的验证码
			if (!"lizhuo".equalsIgnoreCase(account)||!"123456".equals(password)) {// 校验密码
				return "toLogin";
			}
			session.setAttribute(UserContextUtil.USER_INFO,"李卓");
			return "redirect:/";
		}  catch (Exception e) {
			return "toLogin";
		}
	}

	@GetMapping("/loginOut")
	public String loginOut(HttpServletRequest request) {
		final String BUSINESS_NAME = "【下线请求】";
		log.info(BUSINESS_NAME+"------开始");
		request.getSession().invalidate();
		log.info(BUSINESS_NAME+"------结束");
		return "toLogin";
	}
}
