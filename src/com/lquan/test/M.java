package com.lquan.test;

public class M {
	public M() {
		System.out.println("****MMMMAAA****");
	}
	
	public M(String name) {
		System.out.println("****MMMM****"+name);
		
		init();
	}
	
	   void init() {
		   System.out.println("****MMMM---init()****");
	    }
	   
	   
	   public void put(String key) {
		   initx() ;
	}
	   
	   void initx() {
		   System.out.println("****MMMM---initX()****");
	    }
}
