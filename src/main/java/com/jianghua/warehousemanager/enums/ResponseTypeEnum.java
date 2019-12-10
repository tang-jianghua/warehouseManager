package com.jianghua.warehousemanager.enums;

public enum ResponseTypeEnum {
    SUCCESS("0000","请求成功"),
	FAIL("0001","请求失败"),
	PARAM_LOCK("0002","缺少参数"),
	UNLOGIN("0003","未登录"),
	MULTIPLE_COLUMN("0004","数据库多条记录"),
	EXCEPTION("9999","系统异常");

	private String code;

	private String msg;

	public String getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}


	ResponseTypeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
