package com.test.api.demo.exception;

import com.test.api.demo.util.ResponseEnum;

public class TestApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4310227218088238110L;
	
	private String typeCode;
	
	public TestApiException() {
        super();
    }

    public TestApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TestApiException(final String message) {
        super(message);
    }

    public TestApiException(final Throwable cause) {
        super(cause);
    }
    
    public TestApiException(final ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.typeCode = responseEnum.getCode();
    }

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

}
