package com.rendyrobbani.keuangan.common.util.text;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class TextUtilOfClean {

	public static String clean(String text) {
		if (text == null || text.isBlank()) return null;
		return text.trim();
	}

}