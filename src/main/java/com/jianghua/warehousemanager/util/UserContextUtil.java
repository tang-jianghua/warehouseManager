package com.jianghua.warehousemanager.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class UserContextUtil {

	static Logger logger = LoggerFactory.getLogger(UserContextUtil.class);

	private UserContextUtil(){
		logger.warn("公用类，禁止创建对象！");
	}

	// 用于存放用戶session
	private static final ThreadLocal<HttpSession> local = new ThreadLocal<>();

	public static final String USER_INFO = "WAREHOUSE_USER_INFO";

	public static void remove(){
		local.remove();
	}

	public static void setSession(HttpSession httpSession){
		local.set(httpSession);
	}
}
