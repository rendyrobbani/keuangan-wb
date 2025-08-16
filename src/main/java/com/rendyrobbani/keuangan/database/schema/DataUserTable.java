package com.rendyrobbani.keuangan.database.schema;

import com.rendyrobbani.keuangan.database.anotation.Column;
import com.rendyrobbani.keuangan.database.anotation.Table;

@Table(name = "data_user")
public interface DataUserTable {

	@Column(name = "title_prefix", size = "255", nullable = false)
	String titlePrefix();

}