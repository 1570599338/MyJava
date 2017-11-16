package com.lquan.test;

public class linkedM extends M{
	public linkedM(String name) {
		super(name);
		System.out.println("****LinkedM****"+name);
	}
	
	public linkedM() {
		super();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("*****LinkedM-init()******");
	}
	
	
	@Override
	public void initx() {
		// TODO Auto-generated method stub
		System.out.println("*****LinkedM-initx()******");
	}
	
	

}
