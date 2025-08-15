package com.rendyrobbani.keuangan.schema.master.codes.fungsi;

import com.rendyrobbani.keuangan.common.schema.column.Column;
import com.rendyrobbani.keuangan.common.schema.column.ColumnFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BaseMasterFungsiTable {

	private static List<Column> columns;

	public static List<Column> getColumns() {
		if (columns == null) {
			columns = new ArrayList<>();
			columns.add(ColumnFactory.createFungsiCode("code", false));
			columns.add(ColumnFactory.createVarChar("name", false));
		}
		return columns;
	}

}