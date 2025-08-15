package com.rendyrobbani.keuangan.common.codes.subfungsi;

import com.rendyrobbani.keuangan.common.codes.fungsi.FungsiCodes;

public interface SubfungsiCodes extends FungsiCodes {

	String REGEX = "^(?!00\\.0[1-9]|00\\.[1-9][0-9]|0[1-9]\\.00|[1-9][0-9]\\.00)(\\d{2})\\.(\\d{2})$";

	String subfungsiCode();

}