package com.rendyrobbani.keuangan.schema.user;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraint;
import com.rendyrobbani.keuangan.common.schema.constraint.check.CheckConstraintFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantValue")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BaseUserTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createPangkat("pangkat", false));
			columns.add(ColumnFactory.createVarChar("name", false));
			columns.add(ColumnFactory.createVarChar("title_prefix", true));
			columns.add(ColumnFactory.createVarChar("title_suffix", true));
			columns.add(ColumnFactory.createVarChar("password", false));
			columns.add(ColumnFactory.createDateOnly("date_of_birth", false));
			columns.add(ColumnFactory.createDateOnly("date_of_start", true));
			columns.add(ColumnFactory.createGender("gender", false));
			columns.add(ColumnFactory.createSmallInt("number", false));
			columns.add(ColumnFactory.createBoolean("is_pns", false));
			columns.add(ColumnFactory.createBoolean("is_p3k", false));
		}
		return columns;
	}

	public static List<CheckConstraint> getChecks(String tableName, int index) {
		var checks = new ArrayList<CheckConstraint>();
		checks.add(CheckConstraintFactory.columnIsPangkat(tableName, checks.size() + index, "pangkat"));
		checks.add(CheckConstraintFactory.columnIsGender(tableName, checks.size() + index, "gender"));
		checks.add(CheckConstraintFactory.columnsNotEqual(tableName, checks.size() + index, "is_pns", "is_p3k"));
		return checks;
	}

}