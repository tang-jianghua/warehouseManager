package com.jianghua.warehousemanager.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jianghua.warehousemanager.enums.ResponseTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ResponseUtil.class);


	private ResponseUtil(){
		logger.warn("公用类，禁止创建对象！");
	}
	private static final String  END= "------结束";

	public static Map<String,Object> success(String businessName){
		logger.info(businessName+ ResponseTypeEnum.SUCCESS.getMsg());
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.SUCCESS.getCode());
		result.put("msg", ResponseTypeEnum.SUCCESS.getMsg());
		logger.info(businessName+END);
		return result;
	}
	public static Map<String,Object> data(String businessName,Object object){
		logger.info(businessName+ ResponseTypeEnum.SUCCESS.getMsg());
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.SUCCESS.getCode());
		result.put("msg", ResponseTypeEnum.SUCCESS.getMsg());
		result.put("data", object);
		logger.info(businessName+"响应信息: "+ JSON.toJSONString(result));
		logger.info(businessName+END);
		return result;
	}

	public static Map<String,Object> page(String businessName, PageInfo pageInfo){
		logger.info(businessName+ ResponseTypeEnum.SUCCESS.getMsg());
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.SUCCESS.getCode());
		result.put("msg", ResponseTypeEnum.SUCCESS.getMsg());
		result.put("pageIndex",pageInfo.getPageNum());
		result.put("pageRows",pageInfo.getPageSize());
		result.put("pages",pageInfo.getPages());
		result.put("total",pageInfo.getTotal());
		result.put("data",pageInfo.getList());
		logger.info(businessName+END);
		return result;
	}
	
	public static Map<String,Object> fail(String businessName,String msg){
		logger.warn(businessName+ResponseTypeEnum.FAIL.getMsg()+" : "+msg);
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.FAIL.getCode());
		result.put("msg", msg);
		logger.info(businessName+END);
		return result;
	}
	
	public static Map<String,Object> exception(String businessName,String msg,Throwable throwable){
		logger.error(businessName+ResponseTypeEnum.EXCEPTION.getMsg()+" : "+msg,throwable);
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.EXCEPTION.getCode());
		result.put("msg", msg);
		logger.info(businessName+END);
		return result;
	}

	public static String unLogin(){
		logger.warn(ResponseTypeEnum.UNLOGIN.getMsg());
		JSONObject result = new JSONObject();
		result.put("code", ResponseTypeEnum.UNLOGIN.getCode());
		result.put("msg", ResponseTypeEnum.UNLOGIN.getMsg());
		return result.toJSONString();
	}
	
	public static Map<String,Object> paramLock(String businessName,String paramName){
		logger.error(businessName+ResponseTypeEnum.PARAM_LOCK.getMsg()+paramName);
		Map<String,Object> result = new HashMap<>();
		result.put("code", ResponseTypeEnum.PARAM_LOCK.getCode());
		result.put("msg", ResponseTypeEnum.PARAM_LOCK.getMsg()+paramName);
		logger.info(businessName+END);
		return result;
	}
   
	public static Map<String,Object> paramLockCheck(String businessName,Map<String,Object> reqData,String... params){
		for (int i = 0; i < params.length; i++) {
			if(!reqData.containsKey(params[i])||null == reqData.get(params[i])||"".equals(reqData.get(params[i]))) {
				return paramLock(businessName,params[i]);
	    	}
		}
		return null;
	}

}
