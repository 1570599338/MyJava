package com.lquan.annotation.chapter2023;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:       SQLInteger</p>
 * <p>Description: sql的int类型的处理约束</p>
 * <p>Created by  lquan on Jan 3, 201810:48:13 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */


@Retention(RUNTIME)
@Target(FIELD)
public @interface SQLInteger {
	String name() default "";
	Constraints constraints() default @Constraints;
	

}
