package com.rendyrobbani.keuangan.common.schema.column;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ColumnFactory {

	public static Column create(String name,
	                            String size,
	                            ColumnType type,
	                            boolean isNullable,
	                            boolean isPrimaryKey,
	                            boolean isAutoIncrement) {
		size = size == null ? "" : size.trim();
		if (size.startsWith("(")) size = size.substring(1);
		if (size.endsWith(")")) size = size.substring(0, size.length() - 1);
		isAutoIncrement = isAutoIncrement && type.getJavaType().equals(Long.class);
		isPrimaryKey = isPrimaryKey || isAutoIncrement;
		isNullable = isNullable && !isPrimaryKey;
		return new ColumnImpl(name, size.isBlank() ? size : "(" + size + ")", type, isNullable, isPrimaryKey, isAutoIncrement);
	}

	public static Column copyOf(String name,
	                            Column column,
	                            boolean isNullable,
	                            boolean isPrimaryKey) {
		return create(name, column.size(), column.type(), isNullable, isPrimaryKey, false);
	}

	public static Column copyOf(String name,
	                            Column column,
	                            boolean isNullable) {
		return copyOf(name, column, isNullable, false);
	}

	public static Column copyOf(String name,
	                            Column column) {
		return copyOf(name, column, true, false);
	}

	public static Column createVarChar(String name,
	                                   Integer size,
	                                   boolean isNullable,
	                                   boolean isPrimaryKey) {
		size = size != null ? size : 255;
		return create(name, size.toString(), ColumnType.VARCHAR, isNullable, isPrimaryKey, false);
	}

	public static Column createVarChar(String name,
	                                   Integer size,
	                                   boolean isNullable) {
		return createVarChar(name, size, isNullable, false);
	}

	public static Column createVarChar(String name,
	                                   Integer size) {
		return createVarChar(name, size, true, false);
	}

	public static Column createVarChar(String name,
	                                   boolean isNullable,
	                                   boolean isPrimaryKey) {
		return createVarChar(name, null, isNullable, isPrimaryKey);
	}

	public static Column createVarChar(String name,
	                                   boolean isNullable) {
		return createVarChar(name, null, isNullable, false);
	}

	public static Column createVarChar(String name) {
		return createVarChar(name, null, true, false);
	}

	public static Column createChar(String name,
	                                Integer size,
	                                boolean isNullable,
	                                boolean isPrimaryKey) {
		size = size != null ? size : 255;
		return create(name, size.toString(), ColumnType.CHAR, isNullable, isPrimaryKey, false);
	}

	public static Column createChar(String name,
	                                Integer size,
	                                boolean isNullable) {
		return createChar(name, size, isNullable, false);
	}

	public static Column createChar(String name,
	                                Integer size) {
		return createChar(name, size, true, false);
	}

	public static Column createChar(String name,
	                                boolean isNullable,
	                                boolean isPrimaryKey) {
		return createChar(name, null, isNullable, isPrimaryKey);
	}

	public static Column createChar(String name,
	                                boolean isNullable) {
		return createChar(name, null, isNullable, false);
	}

	public static Column createChar(String name) {
		return createChar(name, null, true, false);
	}

	public static Column createBigInt(String name,
	                                  boolean isNullable,
	                                  boolean isPrimaryKey,
	                                  boolean isAutoIncrement) {
		return create(name, "20", ColumnType.BIGINT, isNullable, isPrimaryKey, isAutoIncrement);
	}

	public static Column createBigInt(String name,
	                                  boolean isNullable,
	                                  boolean isPrimaryKey) {
		return createBigInt(name, isNullable, isPrimaryKey, false);
	}

	public static Column createBigInt(String name,
	                                  boolean isNullable) {
		return createBigInt(name, isNullable, false, false);
	}

	public static Column createBigInt(String name) {
		return createBigInt(name, true, false, false);
	}

	public static Column createSmallInt(String name,
	                                    boolean isNullable,
	                                    boolean isPrimaryKey) {
		return create(name, "6", ColumnType.SMALLINT, isNullable, isPrimaryKey, false);
	}

	public static Column createSmallInt(String name,
	                                    boolean isNullable) {
		return createSmallInt(name, isNullable, false);
	}

	public static Column createSmallInt(String name) {
		return createSmallInt(name, true, false);
	}

	public static Column createTinyInt(String name,
	                                   boolean isNullable,
	                                   boolean isPrimaryKey) {
		return create(name, "4", ColumnType.TINYINT, isNullable, isPrimaryKey, false);
	}

	public static Column createTinyInt(String name,
	                                   boolean isNullable) {
		return createTinyInt(name, isNullable, false);
	}

	public static Column createTinyInt(String name) {
		return createTinyInt(name, true, false);
	}

	public static Column createBoolean(String name,
	                                   boolean isNullable) {
		return create(name, "1", ColumnType.BOOLEAN, isNullable, false, false);
	}

	public static Column createBoolean(String name) {
		return createBoolean(name, true);
	}

	public static Column createDateOnly(String name,
	                                    boolean isNullable) {
		return create(name, null, ColumnType.DATEONLY, isNullable, false, false);
	}

	public static Column createDateOnly(String name) {
		return createDateOnly(name, true);
	}

	public static Column createDateTime(String name,
	                                    boolean isNullable) {
		return create(name, null, ColumnType.DATETIME, isNullable, false, false);
	}

	public static Column createDateTime(String name) {
		return createDateTime(name, true);
	}

	// Latte

	public static Column createNip(String name,
	                               boolean isNullable,
	                               boolean isPrimaryKey) {
		return createChar(name, 18, isNullable, isPrimaryKey);
	}

	public static Column createNip(String name,
	                               boolean isNullable) {
		return createNip(name, isNullable, false);
	}

	public static Column createPangkat(String name,
	                                   boolean isNullable,
	                                   boolean isPrimaryKey) {
		return createChar(name, 2, isNullable, isPrimaryKey);
	}

	public static Column createPangkat(String name,
	                                   boolean isNullable) {
		return createPangkat(name, isNullable, false);
	}

	public static Column createGender(String name,
	                                  boolean isNullable,
	                                  boolean isPrimaryKey) {
		return createTinyInt(name, isNullable, isPrimaryKey);
	}

	public static Column createGender(String name,
	                                  boolean isNullable) {
		return createGender(name, isNullable, false);
	}

	public static Column createFungsiCode(String name,
	                                      boolean isNullable,
	                                      boolean isPrimaryKey) {
		return createChar(name, 2, isNullable, isPrimaryKey);
	}

	public static Column createFungsiCode(String name,
	                                      boolean isNullable) {
		return createFungsiCode(name, isNullable, false);
	}

	public static Column createSubfungsiCode(String name,
	                                         boolean isNullable,
	                                         boolean isPrimaryKey) {
		return createChar(name, 5, isNullable, isPrimaryKey);
	}

	public static Column createSubfungsiCode(String name,
	                                         boolean isNullable) {
		return createSubfungsiCode(name, isNullable, false);
	}

	public static Column createUrusanCode(String name,
	                                      boolean isNullable,
	                                      boolean isPrimaryKey) {
		return createChar(name, 1, isNullable, isPrimaryKey);
	}

	public static Column createUrusanCode(String name,
	                                      boolean isNullable) {
		return createUrusanCode(name, isNullable, false);
	}

	public static Column createBidangCode(String name,
	                                      boolean isNullable,
	                                      boolean isPrimaryKey) {
		return createChar(name, 4, isNullable, isPrimaryKey);
	}

	public static Column createBidangCode(String name,
	                                      boolean isNullable) {
		return createBidangCode(name, isNullable, false);
	}

}