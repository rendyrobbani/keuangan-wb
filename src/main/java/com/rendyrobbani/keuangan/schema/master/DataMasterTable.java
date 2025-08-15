package com.rendyrobbani.keuangan.schema.master;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.schema.base.DataTable;
import com.rendyrobbani.keuangan.schema.base.LockTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataMasterTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.addAll(LockTable.getColumns());
			columns.addAll(DataTable.getColumns());
		}
		return columns;
	}

	public static List<ForeignKeyConstraint> getForeignKeys(String tableName, int index) {
		var foreignKeys = new ArrayList<ForeignKeyConstraint>();
		foreignKeys.addAll(LockTable.getForeignKeys(tableName, foreignKeys.size() + index));
		foreignKeys.addAll(DataTable.getForeignKeys(tableName, foreignKeys.size() + index));
		return foreignKeys;
	}

}