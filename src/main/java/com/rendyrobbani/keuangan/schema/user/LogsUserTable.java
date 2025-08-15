package com.rendyrobbani.keuangan.schema.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.base.LogTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LogsUserTable {

	public static final String NAME = "logs_user";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createBigInt("id", false, true, true));
			columns.addAll(BaseUserTable.getColumns());
			columns.add(ColumnFactory.createBoolean("is_locked", false));
			columns.add(ColumnFactory.createBoolean("is_deleted", false));
			columns.addAll(LogTable.getColumns());
			columns.add(ColumnFactory.copyOf("subject_id", DataUserTable.getTable().findColumn("id")));
		}
		return columns;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	private static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LogTable.getForeignKeys(NAME, foreignKeys.size() + 1));
			foreignKeys.add(ForeignKeyConstraintFactory.create(NAME, foreignKeys.size() + 1, "subject_id", DataUserTable.NAME, "id"));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), null, getForeignKeys(), null);
		return table;
	}

}