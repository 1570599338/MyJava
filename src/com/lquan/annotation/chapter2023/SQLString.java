package com.lquan.annotation.chapter2023;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * <p>Title:       SQLString</p>
 * <p>Description: sql的约束</p>
 * <p>Created by  lquan on Jan 3, 201810:44:56 AM </p>
 *<p>@email:  lquan.liu@outlook.com</p>
 */

@Retention(RUNTIME)
@Target(FIELD)
public @interface SQLString {
	int value() default 0;
	String name() default "";
	Constraints constraints() default @Constraints;

}
