package com.kalphix.config.model;

import org.springframework.http.HttpStatus;

/**
 * サーバー側例外発生時、 Restful情報をクライアントに返す。
 * 
 * @author kalphix
 *
 */
public class ExceptionResponse {
	private String status;
	private String errorCode;
	private String errorMessage;

	/**
	 * コンストラクタ
	 * 
	 * @param status
	 *            HTTP response status code
	 */
	public ExceptionResponse(HttpStatus status) {
		this.status = status.toString();
	}

	/**
	 * HTTP Response Statusを取得する。
	 * 
	 * @return HTTP response status code
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * HTTP Response Statusを設定する。
	 * 
	 * @param status
	 *            HTTP response status code
	 * 
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 業務エラーコードを取得する。
	 * 
	 * @return 業務エラーコード
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * 業務エラーコードを設定する。
	 * 
	 * @param errorCode
	 *            業務エラーコード
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 業務エラーコードを設定する。
	 * 
	 * @return 業務エラーメッセージ
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 業務エラーコードを設定する。
	 * 
	 * @param errorMessage
	 *            業務エラーメッセージ
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
