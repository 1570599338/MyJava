package com.lquan.collection.thread.test;

/**
 * Title   VolatileDemo.java
 * Descr   volatile所具备的两个特性
 * 			1:保证volatile修饰的变量对所有线程是可见性，这里的可见性是值当一条线程修改了这个变量的值
 * 			  新值对于其他线程来说是可以立即得知的。但在并发下是不安全的。
 * 			
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月19日 上午12:29:29
 */
public class VolatileDemo {
	
	public volatile static int race = 0;
	
	public static synchronized void increase() {
		synchronized (new Object()) {
			race++;
		}
		
	}
	
	private static int threadCount = 20;

	public static void main(String[] args) {
		Thread[] threads = new Thread[threadCount];
		
		for (int i = 0; i < threadCount; i++) {
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// 运行
					for (int j = 0; j < 1000; j++) {
						increase();
					}
					
				}
			});
			threads[i].start();
		}

		// 等待所有累加线程都结束
		while (Thread.activeCount()>1) {
			Thread.yield();
			System.out.println(race);
			
		}
		
	}

}
