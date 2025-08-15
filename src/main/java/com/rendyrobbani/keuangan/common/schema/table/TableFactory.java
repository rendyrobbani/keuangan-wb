package com.rendyrobbani.keuangan.common.schema.table;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.foreign.ForeignKeyConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.primary.PrimaryConstraintFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.unique.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableFactory {

	public static Table createTable(String name,
	                                List<Column> columns,
	                                List<CheckConstraint> checks,
	                                List<ForeignKeyConstraint> foreignKeys,
	                                List<UniqueConstraint> uniques) {
		return new TableImpl(
				name,
				columns,
				PrimaryConstraintFactory.create(columns.stream().filter(Column::isPrimaryKey).map(Column::name).toList()),
				checks,
				foreignKeys,
				uniques
		);
	}

	public static Table createTableLog(String name, Table subject) {
		var columns = new ArrayList<Column>();
		columns.add(ColumnFactory.createBigInt("id", false, true, true));
		for (var c : subject.columns()) if (!c.isPrimaryKey() && !c.name().endsWith("_at")) columns.add(ColumnFactory.copyOf(c.name(), c));
		columns.add(ColumnFactory.createDateTime("logged_at", true));
		columns.add(ColumnFactory.createNip("logged_by", true));
		columns.add(ColumnFactory.copyOf("subject_id", subject.findColumn("id")));

		var foreignKeys = new ArrayList<ForeignKeyConstraint>();
		for (var k : subject.foreignKeys()) {
			var columnNames = k.columnNames().stream().map(columnName -> columnName.equals("id") ? "subject_id" : columnName).toList();
			foreignKeys.add(ForeignKeyConstraintFactory.create(name, foreignKeys.size() + 1, columnNames, k.referenceTableName(), k.referenceColumnNames()));
		}
		foreignKeys.add(ForeignKeyConstraintFactory.create(name, foreignKeys.size() + 1, "subject_id", subject.name(), "id"));

		return createTable(name, columns, null, foreignKeys, null);
	}

}