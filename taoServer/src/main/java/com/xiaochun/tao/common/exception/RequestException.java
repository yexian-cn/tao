package com.xiaochun.tao.common.exception;

public class RequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7894840947203773193L;

	private String errCode;

	private String errMsg;

	public RequestException() {
		super();
	}

	public RequestException(String message) {
		super(message);
	}

	public RequestException(Throwable cause) {
		super(cause);
	}

	public RequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public Throwable fillInStackTrace() {
		return this;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

}
