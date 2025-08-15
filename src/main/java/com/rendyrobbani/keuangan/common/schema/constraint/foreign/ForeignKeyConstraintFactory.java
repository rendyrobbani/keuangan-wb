package com.rendyrobbani.keuangan.common.schema.constraint.foreign;

import com.rendyrobbani.keuangan.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ForeignKeyConstraintFactory {

	public static ForeignKeyConstraint create(
			String name,
			List<String> columnNames,
			String referenceTableName,
			List<String> referenceColumnNames) {
		return new ForeignKeyConstraintImpl(name, columnNames, referenceTableName, referenceColumnNames);
	}

	public static ForeignKeyConstraint create(
			String tableName,
			Integer index,
			List<String> columnNames,
			String referenceTableName,
			List<String> referenceColumnNames) {
		return create(String.join("_", "fk", tableName.substring(0, Math.min(58, tableName.length())), NumberUtil.lpadZero(index, 2)), columnNames, referenceTableName, referenceColumnNames);
	}

	public static ForeignKeyConstraint create(
			String tableName,
			Integer index,
			String columnName,
			String referenceTableName,
			String referenceColumnName) {
		return create(String.join("_", "fk", tableName.substring(0, Math.min(58, tableName.length())), NumberUtil.lpadZero(index, 2)), List.of(columnName), referenceTableName, List.of(referenceColumnName));
	}

}