package com.lquan.collection.map.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * Title   TestLinkedHshMapDemo.java
 * Descr  linkedHashMap的底层研究。
 * 		1,LinkedHashMap他是继承hashmap的。
 * 			
 * 
 * 
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月13日 上午12:55:03
 */
public class TestLinkedHshMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put(null, "aaaa");
//		linkedHashMap.put("AAA2", "aaaa2");
//		linkedHashMap.put("AAA3", "aaaa3");
//		linkedHashMap.put("AAA4", "aaaa4");
//		linkedHashMap.put("AAA5", "aaaa5");
		
		for(Entry<String, String> e : linkedHashMap.entrySet()){
			System.out.println(e.getKey()+"----"+e.getValue());
		}
//
//		System.out.println();
//		System.out.println("********************");
//		System.out.println();
//		LinkedHashMap<String, String> ll = new LinkedHashMap<String, String>(16, 075f, true);
//		ll.put("AAA", "aaaa");
//		ll.put("AAA2", "aaaa2");
//		ll.put("AAA8", "aaaa8");
//		ll.put("AAA4", "aaaa4");
//		ll.put("AAA5", "aaaa5");
//		System.out.println();
//		System.out.println("********************");
//		System.out.println();
//		for(Entry<String, String> e : ll.entrySet()){
//			System.out.println(e.getKey()+"----"+e.getValue());
//		}
//		System.out.println("*********"+ll.get("AAA2"));
//		
//		for(Entry<String, String> e : ll.entrySet()){
//			System.out.println(e.getKey()+"----"+e.getValue());
//		}
		
	}

}
