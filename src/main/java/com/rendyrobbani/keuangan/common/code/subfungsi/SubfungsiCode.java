package com.rendyrobbani.keuangan.common.code.subfungsi;

import com.rendyrobbani.keuangan.common.code.fungsi.FungsiCode;

public interface SubfungsiCode extends FungsiCode {

	String REGEX = "^(?!00\\.0[1-9]|00\\.[1-9][0-9]|0[1-9]\\.00|[1-9][0-9]\\.00)(\\d{2})\\.(\\d{2})$";

	String subfungsiCode();

}