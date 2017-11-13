package com.lquan.collection.map.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Title   TestHashMapDemo.java
 * Descr   测试hashmap的底层的实现，hashmap的底层实现是由entry链表的数组实现的。结构是数组+链表。
 * 		   原理：根据key的hashcode和teble的长度来确定bucketindex的位置。然后将数据插入对应tble位置。
 * 			利用扰动函数将key的hashcode进行一系列的扰动。然后将返回的hash和（table长度-1）求与返回的结果就是bucketindex的位置。
 * 			然后将键值对的entry对象进行插入（出现hash碰撞问题）。子链增加将新增数据放入table【bucketindex】的位置，之前的数据放在新增数据之后。
 * 
 * Email   lquan.liu@outlook.com 
 * @author lquan
 * @dates  2017年11月13日 上午12:38:22
 */
public class TestHashMapDemo {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "AAA");
		map.put("b", "BBB");
		map.put("c", "CCC");
		
		//System.out.println(map.get("b"));
		/**
		 * 遍历hashmap的方法一
		 * 执行效率较高
		 */
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			//System.out.println(iterator.next());
			Entry<String, String> e = (Entry<String, String>) iterator.next();
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key+"*****"+value);
		}
		
		/**
		 * 遍历hashmap的方法二--利用迭代器进行遍历
		 * 执行效率较低
		 */
		Iterator iterator2 = map.keySet().iterator();
		while (iterator2.hasNext()) {
			//System.out.println(iterator.next());
			Object key = (Object) iterator2.next();
			String value = map.get(key);
			System.out.println(key+"------"+value);
		}
		
		
		/**
		 * 方法三：利用增强for循环进行map的遍历
		 */
		for(Entry<String, String> e:map.entrySet()){
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key+"---&&&--"+value);
		}
		
		for(String e:map.keySet()){
			String key = e;
			String value = map.get(key);
			System.out.println(key+"---888888--"+value);
		}

	}

}
