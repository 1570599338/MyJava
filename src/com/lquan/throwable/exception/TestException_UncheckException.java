package com.lquan.throwable.exception;

import java.util.Date;

import org.junit.Test;

/**
 * 
 * <p>Title:       TestException</p>
 * <p>Description: Exception异常处理 </p>
 * <p>Created by  lquan on Dec 27, 20175:44:44 PM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
public class TestException_UncheckException {
	
	//  运行时异常-- java.lang.ArrayIndexOutOfBoundsException: 10
	@Test
	public void testArrayIndexOutOfBoundsException() {
		int[] i = new int[10];
		System.out.println(i[10]);
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
	
	
	/**
	 * 空指针异常 -- java.lang.NullPointerException
	 */
	@Test
	public void testNullPointerException(){
		Person person = new Person();
		person=null;
		System.out.println(person.toString());
	}
	
	

	
}

/**
 * 
 * <p>Title:       Person</p>
 * <p>Description: TODO</p>
 * <p>Created by  lquan on Dec 28, 201710:22:10 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
class Person{
	
}
