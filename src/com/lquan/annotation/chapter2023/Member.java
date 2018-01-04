package com.lquan.annotation.chapter2023;


/**
 * 
 * <p>Title:       Member</p>
 * <p>Description: TODO</p>
 * <p>Created by  lquan on Jan 3, 201811:06:29 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 *<p>   </p>
 */

@DBTable(name="MEMBER")
public class Member {
	@SQLString(30) 
	String firstName;
	
	
	@SQLString(50)
	String lasteName;
	
	@SQLInteger
	Integer age;
	
	@SQLString(value=30,constraints=@Constraints(primaryKey=true))
	String handle;

	public String getFirstName() {
		return firstName;
	}

	public String getLasteName() {
		return lasteName;
	}


	public Integer getAge() {
		return age;
	}


	public String getHandle() {
		return handle;
	}

	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lasteName=" + lasteName + ", age=" + age + ", handle=" + handle
				+ "]";
	}

	
	
	

}
