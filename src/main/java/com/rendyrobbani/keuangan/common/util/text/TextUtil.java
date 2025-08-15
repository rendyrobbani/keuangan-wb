package com.rendyrobbani.keuangan.common.util.text;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TextUtil {

	public static String toTitleCase(String text,
	                                 Map<String, String> replaceBefore,
	                                 Map<String, String> replaceAfter) {
		return TextUtilOfCase.toTitleCase(text, replaceBefore, replaceAfter);
	}

	public static String toTitleCase(String text,
	                                 Map<String, String> replaceBefore) {
		return TextUtilOfCase.toTitleCase(text, replaceBefore, null);
	}

	public static String toTitleCase(String text) {
		return TextUtilOfCase.toTitleCase(text, null, null);
	}

	public static String toCamelCase(String text,
	                                 Map<String, String> replaceBefore,
	                                 Map<String, String> replaceAfter) {
		return TextUtilOfCase.toCamelCase(text, replaceBefore, replaceAfter);
	}

	public static String toCamelCase(String text,
	                                 Map<String, String> replaceBefore) {
		return TextUtilOfCase.toCamelCase(text, replaceBefore, null);
	}

	public static String toCamelCase(String text) {
		return TextUtilOfCase.toCamelCase(text, null, null);
	}

	public static String trim(String text) {
		return TextUtilOfClean.clean(text);
	}

}