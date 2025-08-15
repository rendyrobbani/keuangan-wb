package com.rendyrobbani.keuangan.common.util.name;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameUtil {

	public static String onlyName(String name,
	                              boolean toUpperCase) {
		if (name == null || name.isBlank()) return name;

		if (toUpperCase) {
			if (name.startsWith("Hj.")) return name.toUpperCase().replace("HJ.", "Hj.");
			return name.toUpperCase();
		}
		return name;
	}

	public static String fullName(String name,
	                              boolean toUpperCase,
	                              String titlePrefix,
	                              String titleSuffix) {
		if (name == null || name.isBlank()) return name;

		var fullName = onlyName(name, toUpperCase);
		if (titlePrefix != null && !titlePrefix.isEmpty()) fullName = titlePrefix + " " + fullName;
		if (titleSuffix != null && !titleSuffix.isEmpty()) fullName = fullName + ", " + titleSuffix;
		return fullName;
	}

}