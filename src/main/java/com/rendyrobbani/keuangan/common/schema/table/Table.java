package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.primary.PrimaryConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.unique.UniqueConstraint;

import java.util.ArrayList;
import java.util.List;

public interface Table {

	String ENGINE = "innodb";
	String CHARSET = "utf8mb4";
	String COLLATE = "utf8mb4_unicode_ci";

	String name();

	List<Column> columns();

	PrimaryConstraint primary();

	List<CheckConstraint> checks();

	List<ForeignKeyConstraint> foreignKeys();

	List<UniqueConstraint> uniques();

	default Column findColumn(String name) {
		return this.columns().stream().filter(c -> c.name().equals(name)).findFirst().orElse(null);
	}

	default String getDeleteDDL(boolean useIfExists) {
		return String.join(" ", "drop table" + (useIfExists ? " if exists" : ""), this.name()) + ";";
	}

	default String getDeleteDDL() {
		return this.getDeleteDDL(true);
	}

	default String getCreateDDL(boolean useOrReplace) {
		List<String> ddl = new ArrayList<>();
		ddl.add("create " + (useOrReplace ? "or replace " : "") + "table " + this.name() + " (");
		int maxName = 0;
		int maxType = 0;
		for (var column : this.columns()) {
			maxName = Math.max(maxName, column.name().length());
			maxType = Math.max(maxType, column.typeAndSize().length());
		}
		for (var column : this.columns()) {
			var name = column.name() + " ".repeat(maxName - column.name().length());
			var type = column.typeAndSize() + " ".repeat(maxType - column.typeAndSize().length());
			var attr = column.isNullable() ? "null" : "not null";
			if (column.isAutoIncrement()) attr += " auto_increment";
			ddl.add("\t" + String.join(" ", name, type, attr) + ",");
		}
		if (checks() != null) for (var c : this.checks()) ddl.add("\t" + c.nameAndValue() + ",");
		if (foreignKeys() != null) for (var c : this.foreignKeys()) ddl.add("\t" + c.nameAndValue() + ",");
		if (uniques() != null) for (var c : this.uniques()) ddl.add("\t" + c.nameAndValue() + ",");
		ddl.add("\t" + this.primary().value());
		ddl.add(") engine = " + ENGINE);
		ddl.add("  charset = " + CHARSET);
		ddl.add("  collate = " + COLLATE + ";");
		return String.join(System.lineSeparator(), ddl);
	}

	default String getCreateDDL() {
		return this.getCreateDDL(true);
	}

}