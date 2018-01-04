package com.lquan.annotation.chapter2023;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:       Constraints</p>
 * <p>Description: 约束条件</p>
 * <p>Created by  lquan on Jan 3, 201810:38:27 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
	
	boolean primaryKey() default false; // 主键
	boolean allowNull() default true; // 允许为空
	boolean unique() default false; // 是否唯一

}
