package com.lquan.throwable.exception.opration;

import java.util.Date;

import org.junit.Test;

public class ExceptionOpration {
	
	
	//  运行时异常-- java.lang.ArrayIndexOutOfBoundsException: 10
	@Test
	public void testArrayIndexOutOfBoundsException() {
		try {
			int[] i = new int[10];
			System.out.println(i[10]);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("异常处理………………"+e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("异常处理………………");
	}
	

	
	/**
	 * java.lang.ArithmeticException: / by zero
	 *   算数异常  ***/
	@Test
	public void testArithmeticException() {
		System.out.println(1/0);
	}
	
	/**
	 * 类型转换异常 -- java lang.ClassCastException()
	 */
	@Test
	public void testClassCastException() {
		Object object = new Date();
		String date = (String) object;
	}
	
	

}
