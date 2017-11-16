package com.lquan.collection.base.test;

import java.math.BigDecimal;

/**
 * Title   DoubleDemo.java
 * Descr   验证double的计算和比较问题。
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月17日 上午2:15:32
 */
public class DoubleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1,直接对double进行比较会出现精度问题。
		double aa = 4.1111;
		double bb = 4.1111;
		double c= aa + bb;
		System.out.println(c);
		
		// 2,利用double转换成long类型只能解决比较大小问题，不能解决计算问题
		long a = Double.doubleToLongBits(2.11);
		long b = Double.doubleToLongBits(2.11);
		System.err.println(a +"***"+b+"***"+(a+b)+"**"+(aa==bb));
		double xx = Double.longBitsToDouble(a+b);
		System.out.println(xx);
		
		
		// 利用BigDecimal来解决double的上精度计算问题。
		BigDecimal aBigDecimal=BigDecimal.valueOf(2.212);
		BigDecimal bBigDecimal=BigDecimal.valueOf(1.212);
		
		

	}

}
