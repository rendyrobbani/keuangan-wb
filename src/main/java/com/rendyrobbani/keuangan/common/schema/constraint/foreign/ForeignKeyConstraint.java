package com.rendyrobbani.keuangan.common.schema.constraint.foreign;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

import java.util.List;

public interface ForeignKeyConstraint extends Constraint {

	List<String> columnNames();

	String referenceTableName();

	List<String> referenceColumnNames();

	@Override
	default String value() {
		return String.join(" ",
		                   "foreign key",
		                   "(" + String.join(", ", columnNames()) + ")",
		                   "references",
		                   referenceTableName(),
		                   "(" + String.join(", ", referenceColumnNames()) + ")"
		                  );
	}

}