package com.xiaochun.tao.common.exception;

public class ServiceRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7894840947203773193L;
	
	public ServiceRuntimeException() {
		super();
	}
	
	public ServiceRuntimeException(String message) {
		super(message);
	}

	public ServiceRuntimeException(Throwable cause) {
		super(cause);
	}

	public ServiceRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 出于性能考虑， 复写此方法。
	 */
	public Throwable fillInStackTrace() {
		return this;
	}

	
}
