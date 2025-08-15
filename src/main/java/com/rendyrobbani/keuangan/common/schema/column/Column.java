package com.rendyrobbani.keuangan.common.schema.column;

public interface Column {

	String name();

	String size();

	boolean isNullable();

	boolean isPrimaryKey();

	boolean isAutoIncrement();

	ColumnType type();

	default String typeAndSize() {
		return this.type().getDataType() + this.size();
	}

}