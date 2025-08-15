package com.rendyrobbani.keuangan.common.schema.constraint.primary;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface PrimaryConstraint extends Constraint {

	@Override
	default String name() {
		return "PRIMARY";
	}

	List<String> columnNames();

	@Override
	default String value() {
		return "primary key (" + String.join(", ", this.columnNames()) + ")";
	}

}