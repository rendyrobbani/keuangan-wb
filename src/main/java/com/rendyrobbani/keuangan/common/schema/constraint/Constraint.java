package com.rendyrobbani.keuangan.common.schema.constraint;

public interface Constraint {

	String name();

	String value();

	default String nameAndValue() {
		return "constraint " + this.name() + " " + this.value();
	}

}