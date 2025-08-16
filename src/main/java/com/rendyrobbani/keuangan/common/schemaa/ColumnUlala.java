package com.rendyrobbani.keuangan.common.schemaa;

public interface ColumnUlala {

	@Column(name = "id", size = "25", isNullable = false, isPrimaryKey = true)
	String id();

}