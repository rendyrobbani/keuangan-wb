package com.rendyrobbani.keuangan.domain.model.marker;

import com.rendyrobbani.keuangan.common.util.name.NameUtil;

public interface HasNameAndTitles extends HasName {

	String titlePrefix();

	String titleSuffix();

	default String onlyName(boolean toUpperCase) {
		return NameUtil.onlyName(name(), toUpperCase);
	}

	default String fullName(boolean toUpperCase) {
		return NameUtil.fullName(name(), toUpperCase, titlePrefix(), titleSuffix());
	}

}