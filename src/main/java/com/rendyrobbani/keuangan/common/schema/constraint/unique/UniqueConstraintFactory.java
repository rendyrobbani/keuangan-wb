package com.rendyrobbani.keuangan.common.schema.constraint.unique;

import com.rendyrobbani.keuangan.common.util.number.NumberUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UniqueConstraintFactory {

	public static UniqueConstraint create(
			String name,
			List<String> columnNames) {
		return new UniqueConstraintImpl(name, columnNames);
	}

	public static UniqueConstraint create(
			String tableName,
			Integer index,
			List<String> columnNames) {
		return create(String.join("_", "uk", tableName.substring(0, Math.min(58, tableName.length())), NumberUtil.lpadZero(index, 2)), columnNames);
	}

}