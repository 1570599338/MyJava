package com.lquan.throwable.exception.defineException;

/**
 * 
 * <p>Title:       MyException</p>
 * <p>Description: 自定义的异常处理类</p>
 * <p>Created by  lquan on Dec 28, 20176:50:36 PM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
public class MyException extends RuntimeException{

	/****/
	private static final long serialVersionUID = 121211L;

	public MyException() {
		super();
	}


	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	
	

}
