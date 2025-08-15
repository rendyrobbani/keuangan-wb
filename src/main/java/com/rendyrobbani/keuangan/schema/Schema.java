package com.rendyrobbani.keuangan.schema;

import com.rendyrobbani.keuangan.common.schema.table.Table;
import com.rendyrobbani.keuangan.schema.master.codes.fungsi.DataMasterFungsiTable;
import com.rendyrobbani.keuangan.schema.user.DataUserTable;
import com.rendyrobbani.keuangan.schema.user.LogsUserTable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Schema {

	private static List<Table> tables;

	public static List<Table> getTables() {
		if (tables == null) {
			tables = new ArrayList<>();
			tables.add(DataUserTable.getTable());
			tables.add(LogsUserTable.getTable());

			tables.add(DataMasterFungsiTable.getTable());
		}
		return tables;
	}

}