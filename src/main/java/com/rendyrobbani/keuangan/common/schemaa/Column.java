package com.rendyrobbani.keuangan.common.schemaa;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	String name();

	String size() default "";

	boolean isNullable() default true;

	boolean isPrimaryKey() default false;

	boolean isAutoIncrement() default false;

}