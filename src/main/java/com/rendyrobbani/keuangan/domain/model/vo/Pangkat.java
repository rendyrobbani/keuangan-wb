package com.rendyrobbani.keuangan.domain.model.vo;

public interface Pangkat {

	String REGEX_PNS = "[1-4][A-D]|4E";
	String REGEX_P3K = "0[1-9]|1[0-7]";
	String REGEX = REGEX_PNS + "|" + REGEX_P3K;

	String value();

	String label();

	String title();

	boolean isPNS();

	boolean isP3K();

}