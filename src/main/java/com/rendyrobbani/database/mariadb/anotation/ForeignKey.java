package com.rendyrobbani.database.mariadb.anotation;

public @interface ForeignKey {

	String[] columns();

	Class<?> referenceTable();

	String[] referenceColumns();

}