package com.lquan.throwable.exception;

import org.junit.Test;

/**
 * 
 * <p>Title:       TestException</p>
 * <p>Description: Exception异常处理 </p>
 * <p>Created by  lquan on Dec 27, 20175:44:44 PM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
public class TestException {
	
	//  运行时异常-- java.lang.ArrayIndexOutOfBoundsException: 10
	@Test
	public void testArrayIndexOutOfBoundsException() {
		int[] i = new int[10];
		System.out.println(i[10]);
	}
	

}
