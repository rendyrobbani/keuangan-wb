package com.rendyrobbani.keuangan.database;

import com.rendyrobbani.database.mariadb.TableGenerator;
import com.rendyrobbani.database.mariadb.anotation.Table;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	private static List<Class<?>> tables;

	public static List<Class<?>> tables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(TableOfDataUser.class);
			tables.add(TableOfLogsUser.class);

			tables = tables.stream().filter(c -> c.isAnnotationPresent(Table.class)).toList();
		}
		return tables;
	}

	public static void generateDDL(File root) throws IOException {
		if (root.exists() || root.mkdirs()) {
			for (int i = 0; i < tables().size(); i++) {
				Table table = tables().get(i).getAnnotation(Table.class);

				File file = new File(root, String.format("%03d", i + 1) + "-" + table.name() + ".sql");
				try (FileOutputStream fos = new FileOutputStream(file)) {
					fos.write(TableGenerator.generateDeleteDDL(tables().get(i)).getBytes());
					fos.write(System.lineSeparator().getBytes());
					fos.write(System.lineSeparator().getBytes());
					fos.write(TableGenerator.generateCreateDDL(tables().get(i)).getBytes());
				}
			}
		}
	}

}