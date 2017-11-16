package com.lquan.test;

public class M {
	public M() {
		System.out.println("****MMMMAAA****");
	}
	
	public M(String name) {
		System.out.println("****MMMM****"+name);
		
		init();
	}
	
	public void init() {
		   System.out.println("****MMMM---init()****");
	    }
	   
	   
	   public void put(String key) {
		   initx() ;
	}
	   
	   public void initx() {
		   System.out.println("****MMMM---initX()****");
	    }
	   
	   public  final void eat() {
		   System.out.println("****MMMM---eat()****");
	    }
}
