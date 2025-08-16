package com.rendyrobbani.database.mariadb.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	String name();

	int length() default 0;

	boolean autoIncrement() default false;

	boolean primaryKey() default false;

	boolean nullable() default true;

}