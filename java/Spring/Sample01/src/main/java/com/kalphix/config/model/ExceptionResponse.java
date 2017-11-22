package com.kalphix.config.model;

import org.springframework.http.HttpStatus;

/**
 * �T�[�o�[����O�������A Restful�����N���C�A���g�ɕԂ��B
 * 
 * @author kalphix
 *
 */
public class ExceptionResponse {
	private String status;
	private String errorCode;
	private String errorMessage;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param status
	 *            HTTP response status code
	 */
	public ExceptionResponse(HttpStatus status) {
		this.status = status.toString();
	}

	/**
	 * HTTP Response Status���擾����B
	 * 
	 * @return HTTP response status code
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * HTTP Response Status��ݒ肷��B
	 * 
	 * @param status
	 *            HTTP response status code
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * �Ɩ��G���[�R�[�h���擾����B
	 * 
	 * @return �Ɩ��G���[�R�[�h
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * �Ɩ��G���[�R�[�h��ݒ肷��B
	 * 
	 * @param errorCode
	 *            �Ɩ��G���[�R�[�h
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * �Ɩ��G���[�R�[�h��ݒ肷��B
	 * 
	 * @return �Ɩ��G���[���b�Z�[�W
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * �Ɩ��G���[�R�[�h��ݒ肷��B
	 * 
	 * @param errorMessage
	 *            �Ɩ��G���[���b�Z�[�W
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
