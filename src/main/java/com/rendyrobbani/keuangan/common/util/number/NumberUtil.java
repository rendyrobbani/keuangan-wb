package com.rendyrobbani.keuangan.common.util.number;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NumberUtil {

	public static String lpadZero(Integer number,
	                              int length) {
		return NumberUtilOfPad.lpadZero(number, length);
	}

	public static String lpadZero(Long number,
	                              int length) {
		return NumberUtilOfPad.lpadZero(number, length);
	}

	public static String toRoman(Integer number) {
		return NumberUtilOfRoman.toRoman(number);
	}

	public static String toRoman(Long number) {
		return NumberUtilOfRoman.toRoman(number);
	}

	public static String toRoman(String number) {
		return NumberUtilOfRoman.toRoman(number);
	}

	public static int fromRoman(String roman) {
		return NumberUtilOfRoman.fromRoman(roman);
	}

}