package com.kalphix.exception;

/**
 * �Ɩ���O
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
	 * @return �Ɩ��G���[�R�[�h
	 */
	public String getBizErrorCode() {
		return bizErrorCode;
	}

	/**
	 * 
	 * @return �Ɩ��G���[���b�Z�[�W
	 */
	public String getBizErrorMessage() {
		return bizErrorMessage;
	}

}
