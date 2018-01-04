package com.lquan.annotation.chapter2023;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:       DBTable</p>
 * <p>Description: annotations database DBTable.java</p>
 * <p>Created by  lquan on Jan 3, 201810:30:04 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 *<p> @DBTable 有一个name()元素，该注解通过这个元素为处理器创建数据库提供表的名字。</p>
 */

@Target(ElementType.TYPE) // Applies to classes only
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	public String name() default ""; //主要是为了记录数据库表名
}
