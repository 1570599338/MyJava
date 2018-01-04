package com.lquan.annotation.chapter2023;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Uniqueness {
	Constraints constraints() default @Constraints(unique=true);

}
