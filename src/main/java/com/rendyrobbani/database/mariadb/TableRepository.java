package com.rendyrobbani.database.mariadb;

import com.rendyrobbani.database.mariadb.anotation.Column;
import com.rendyrobbani.database.mariadb.anotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class TableRepository<T> {

	private final Class<T> tableClass;

	private final String tableName;

	@SuppressWarnings("unchecked")
	protected TableRepository() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		if (genericSuperclass instanceof ParameterizedType parameterizedType) {
			this.tableClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		} else {
			throw new IllegalStateException("Tidak bisa menentukan entityClass dari " + getClass());
		}
		if (!tableClass.isAnnotationPresent(Table.class)) {
			throw new IllegalArgumentException("Class " + tableClass.getName() + " harus beranotasi @Table");
		}

		this.tableName = tableClass.getAnnotation(Table.class).name();
	}

	public List<T> selectAll(Connection connection) throws Exception {
		try (var statement = connection.prepareStatement("select * from " + this.tableName)) {
			try (var rs = statement.executeQuery()) {
				var list = new ArrayList<T>();
				while (rs.next()) {
					var t = tableClass.getDeclaredConstructor().newInstance();
					for (Field field : Arrays.stream(tableClass.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Column.class)).toList()) {
						field.setAccessible(true);
						field.set(t, rs.getObject(field.getAnnotation(Column.class).name(), field.getType()));
					}
					list.add(t);
				}
				return list;
			}
		}
	}

}