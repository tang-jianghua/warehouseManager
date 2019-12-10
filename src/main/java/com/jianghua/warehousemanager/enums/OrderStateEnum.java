package com.jianghua.warehousemanager.enums;

public enum OrderStateEnum {

	NORMAL(1,"正常"),
	REMOVED(0,"删除");

	private Integer code;

	private String msg;

	public Integer getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}


	OrderStateEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
