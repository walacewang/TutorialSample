package com.kalphix.exception;

/**
 * 業務例外
 * 
 * @author kalphix
 *
 */
public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bizErrorCode = "";
	private String bizErrorMessage = "";

	public BizException(String bizErrorCode, String bizErrorMessage) {
		super(bizErrorCode + ":" + bizErrorMessage);

		this.bizErrorCode = bizErrorCode;

		this.bizErrorMessage = bizErrorMessage;
	}

	/**
	 * 
	 * @return 業務エラーコード
	 */
	public String getBizErrorCode() {
		return bizErrorCode;
	}

	/**
	 * 
	 * @return 業務エラーメッセージ
	 */
	public String getBizErrorMessage() {
		return bizErrorMessage;
	}

}
