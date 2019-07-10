package com.test.api.demo.util;

import com.test.api.demo.util.Const;

public enum ResponseEnum {
	NOT_FOUND(Const.NOT_FOUND_CODE, Const.NOT_FOUND_MESSAGE), 
	BAD_REQUEST(Const.BAD_REQUEST_CODE, Const.BAD_REQUEST_MESSAGE), 
	SYSTEM_ERROR(Const.INTERNAL_ERROR_CODE,	Const.INTERNAL_ERROR_MESSAGE), 
	INVALID_ERROR(Const.INVALID_CODE,	Const.INVALID_MESSAGE);

	String code;
	String message;

	ResponseEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
