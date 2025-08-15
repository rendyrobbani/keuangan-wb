package com.rendyrobbani.keuangan.common.util.number;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class NumberUtilOfPad {

	public static String lpadZero(Integer number,
	                              int length) {
		if (number == null) return null;
		if (number < 0) return null;

		var num = number.toString();
		var len = Math.max(0, length - num.length());
		if (len == 0) return num;

		var val = new String[len];
		Arrays.fill(val, "0");
		return String.join("", val) + num;
	}

	public static String lpadZero(Long number,
	                              int length) {
		return lpadZero(number.intValue(), length);
	}

}