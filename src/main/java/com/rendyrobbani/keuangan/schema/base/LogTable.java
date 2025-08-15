package com.rendyrobbani.keuangan.schema.base;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.schema.user.BaseUserTable;
import com.rendyrobbani.keuangan.schema.user.DataUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createDateTime("logged_at", true));
			columns.add(ColumnFactory.createNip("logged_by", true));
		}
		return columns;
	}

	public static List<ForeignKeyConstraint> getForeignKeys(String tableName, int index) {
		var foreignKeys = new ArrayList<ForeignKeyConstraint>();
		foreignKeys.add(ForeignKeyConstraintFactory.create(tableName, foreignKeys.size() + index, "logged_by", DataUserTable.NAME, "id"));
		return foreignKeys;
	}

}