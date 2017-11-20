package com.lquan.collection.thread.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title   AtomicIntegerDemo.java
 * Descr   利用Atomic的院子性来解决数据共享问题。
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月20日 下午5:53:38
 */
public class AtomicIntegerDemo {

	private static	AtomicInteger race = new AtomicInteger(0);
	
	public static void increase(){
		// rance自增
		race.incrementAndGet();
	}
	
	private static final int Thread_count = 20;
	
	
	public static void main(String[] args) {
		// 创建线程
		Thread[] threads = new Thread[Thread_count];
		
		for (int i = 0; i < Thread_count; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		
		while (Thread.activeCount()>1) {
			Thread.yield();
		}
		System.out.println(race);
		
		
		
		
		
		

	}

}
