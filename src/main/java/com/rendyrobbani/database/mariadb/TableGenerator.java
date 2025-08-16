package com.rendyrobbani.database.mariadb;

import com.rendyrobbani.database.mariadb.anotation.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TableGenerator {

	private static String type(Field field, Column column) {
		if (field.getType() == Long.class) return "bigint(20)";
		if (field.getType() == Integer.class) return "int(11)";
		if (field.getType() == boolean.class) return "bit(1)";
		if (field.getType() == BigDecimal.class) return "decimal(38,2)";
		if (field.getType() == LocalDate.class) return "date";
		if (field.getType() == LocalDateTime.class) return "datetime";
		if (field.getType() == String.class) return "varchar(" + (column.length() > 0 ? column.length() : 255) + ")";
		throw new RuntimeException();
	}

	public static String generateCreateDDL(Class<?> tableClass, boolean useOrReplace) {
		if (!tableClass.isAnnotationPresent(Table.class)) throw new RuntimeException("Table class is not annotated with @com.rendyrobbani.database.mariadb.anotation.Table");

		Table table = tableClass.getAnnotation(Table.class);

		int max1 = 0;
		int max2 = 0;
		int max3 = 0;

		List<String> primaryKeys = new ArrayList<>();
		List<List<String>> columns = new ArrayList<>();
		for (Field field : tableClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Column.class)) {
				var column = field.getAnnotation(Column.class);

				var autoIncrement = field.getType() == Long.class && column.autoIncrement();
				var primaryKey = autoIncrement || column.primaryKey();
				var nullable = column.nullable() && !primaryKey;

				var colName = column.name();
				max1 = Math.max(max1, colName.length());

				var colType = type(field, column);
				max2 = Math.max(max2, colType.length());

				var colNull = nullable ? "null" : "not null";
				max3 = Math.max(max3, colNull.length());

				if (autoIncrement) columns.add(List.of(colName, colType, colNull, "auto_increment"));
				else columns.add(List.of(colName, colType, colNull));

				if (primaryKey) primaryKeys.add(colName);
			}
		}

		List<String> ddl = new ArrayList<>();
		ddl.add("create " + (useOrReplace ? "or replace " : "") + "table " + table.name() + " (");

		for (List<String> column : columns) {
			var row = new ArrayList<String>();
			row.add("\t");
			row.add(column.get(0));
			row.add(" ".repeat(max1 - column.get(0).length() + 1));
			row.add(column.get(1));
			row.add(" ".repeat(max2 - column.get(1).length() + 1));
			row.add(column.get(2));
			if (column.size() > 3) {
				row.add(" ".repeat(max3 - column.get(2).length() + 1));
				row.add(column.get(3));
			}
			ddl.add(String.join("", row) + ",");
		}

		if (tableClass.isAnnotationPresent(Checks.class)) {
			Checks checks = tableClass.getAnnotation(Checks.class);
			int i = 1;
			for (Check check : checks.value()) {
				String name = String.join("_", "ck", table.name(), String.format("%02d", i));
				ddl.add("\t" + "constraint " + name + " check (" + check.expression() + ")" + ",");
				i++;
			}
		}

		if (tableClass.isAnnotationPresent(ForeignKeys.class)) {
			ForeignKeys foreignKeys = tableClass.getAnnotation(ForeignKeys.class);
			int i = 1;
			for (ForeignKey foreignKey : foreignKeys.value()) {
				String name = String.join("_", "fk", table.name(), String.format("%02d", i));
				String fromColumns = "(" + String.join(", ", Arrays.asList(foreignKey.columns())) + ")";
				String intoTable = foreignKey.referenceTable().getAnnotation(Table.class).name();
				String intoColumns = "(" + String.join(", ", Arrays.asList(foreignKey.referenceColumns())) + ")";
				ddl.add("\t" + "constraint " + name + " foreign key " + fromColumns + " references " + intoTable + " " + intoColumns + ",");
				i++;
			}
		}

		if (tableClass.isAnnotationPresent(Uniques.class)) {
			Uniques uniques = tableClass.getAnnotation(Uniques.class);
			int i = 1;
			for (Unique unique : uniques.value()) {
				String name = String.join("_", "uk", table.name(), String.format("%02d", i));
				String fromColumns = "(" + String.join(", ", Arrays.asList(unique.columns())) + "),";
				ddl.add("\t" + "constraint " + name + " unique key " + fromColumns);
				i++;
			}
		}

		if (!primaryKeys.isEmpty()) ddl.add("\t" + "primary key (" + String.join(", ", primaryKeys) + ")");

		ddl.add(") engine = " + table.engine());
		ddl.add("  charset = " + table.charset());
		ddl.add("  collate = " + table.collate() + ";");
		return String.join(System.lineSeparator(), ddl);
	}

	public static String generateCreateDDL(Class<?> tableClass) {
		return generateCreateDDL(tableClass, true);
	}

	public static String generateDeleteDDL(Class<?> tableClass, boolean useIfExists) {
		if (!tableClass.isAnnotationPresent(Table.class)) throw new RuntimeException("Table class is not annotated with @com.rendyrobbani.database.mariadb.anotation.Table");

		Table table = tableClass.getAnnotation(Table.class);

		return "drop table " + (useIfExists ? "if exists " : "") + table.name() + ";";
	}

	public static String generateDeleteDDL(Class<?> tableClass) {
		return generateDeleteDDL(tableClass, true);
	}

}