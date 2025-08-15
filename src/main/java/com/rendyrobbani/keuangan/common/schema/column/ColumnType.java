package com.rendyrobbani.keuangan.common.schema.column;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ColumnType {
	CHAR("char", String.class),
	VARCHAR("varchar", String.class),
	TINYINT("tinyint", Integer.class),
	SMALLINT("smallint", Integer.class),
	BIGINT("bigint", Long.class),
	BOOLEAN("bit", Boolean.class),
	DATEONLY("date", java.time.LocalDate.class),
	DATETIME("datetime", java.time.LocalDateTime.class),
	DECIMAL("decimal", java.math.BigDecimal.class);

	private final String dataType;

	private final Class<?> javaType;
}