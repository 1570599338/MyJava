package com.lquan.Enum.test;

/**
 * 
 * <p>Title:       SimpleEnumUse</p>
 * <p>Description: 测试枚举</p>
 * <p>Created by  lquan on Jan 1, 20187:19:31 PM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */
public class SimpleEnumUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiciness  howhot = Spiciness.HOT;
		//System.out.println(howhot);
		for(Spiciness s : Spiciness.values()) {
			System.out.println(s + ".ordinal"+s.ordinal());
		}

	}

}
