package com.lquan.collection.set.test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Title   TestHashSetDemo.java
 * Descr   HashSet是实现set借口，底层是利用hashmap来实现的，只不过hashmap的value在hashset的中是默认的object的
 * 		   
 * 		   
 * 		   
 * 		   
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月13日 上午12:14:14
 */
public class TestHashSetDemo {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("aaaaa");
		hashSet.add("bbbb");
		
		for (Iterator iterator = hashSet.iterator(); iterator.hasNext();) {
			
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		for(String h:hashSet){
			System.out.println(h);
		}

	}

}
