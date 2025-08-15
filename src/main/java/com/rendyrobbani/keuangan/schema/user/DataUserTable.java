package com.rendyrobbani.keuangan.schema.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.common.schema.table.TableFactory;
import com.rendyrobbani.keuangan.schema.base.DataTable;
import com.rendyrobbani.keuangan.schema.base.LockTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataUserTable {

	public static final String NAME = "data_user";

	private static List<Column> columns;

	private static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createNip("id", false, true));
			columns.addAll(BaseUserTable.getColumns());
			columns.addAll(LockTable.getColumns());
			columns.addAll(DataTable.getColumns());
		}
		return columns;
	}

	private static List<CheckConstraint> checks;

	private static List<CheckConstraint> getChecks() {
		if (checks == null) {
			checks = new ArrayList<>();
			checks.add(CheckConstraintFactory.columnIsNip(NAME, checks.size() + 1, "id"));
			checks.addAll(BaseUserTable.getChecks(NAME, checks.size() + 1));
		}
		return checks;
	}

	private static List<ForeignKeyConstraint> foreignKeys;

	private static List<ForeignKeyConstraint> getForeignKeys() {
		if (foreignKeys == null) {
			foreignKeys = new ArrayList<>();
			foreignKeys.addAll(LockTable.getForeignKeys(NAME, foreignKeys.size() + 1));
			foreignKeys.addAll(DataTable.getForeignKeys(NAME, foreignKeys.size() + 1));
		}
		return foreignKeys;
	}

	private static Table table;

	public static Table getTable() {
		if (table == null) table = TableFactory.createTable(NAME, getColumns(), getChecks(), getForeignKeys(), null);
		return table;
	}

}