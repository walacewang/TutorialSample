package com.zac.com;

public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String bizErrorCode = "";

	public BizException(String bizErrorCode) {
		super(String.format("BizExecption occured, (code=%s).", bizErrorCode));
		this.bizErrorCode = bizErrorCode;

	}

	public String getBizErrorCode() {
		return bizErrorCode;
	}

}
