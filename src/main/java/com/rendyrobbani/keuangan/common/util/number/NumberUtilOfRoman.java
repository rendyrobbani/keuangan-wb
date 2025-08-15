package com.rendyrobbani.keuangan.common.util.number;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class NumberUtilOfRoman {

	private static final String[] ROMANS = {
			"M", "CM", "D", "CD", "C", "XC",
			"L", "XL", "X", "IX", "V", "IV", "I"
	};

	private static final int[] VALUES = {
			1000, 900, 500, 400, 100, 90,
			50, 40, 10, 9, 5, 4, 1
	};

	private static final Map<Character, Integer> ROMAN_MAP = Map.of(
			'I', 1,
			'V', 5,
			'X', 10,
			'L', 50,
			'C', 100,
			'D', 500,
			'M', 1000
	                                                               );

	public static String toRoman(Integer number) {
		if (number == null) throw new IllegalArgumentException("number cannot be null");
		if (number <= 0 || number > 3999) throw new IllegalArgumentException("Number must be between 1 and 3999");

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < VALUES.length; i++) {
			while (number >= VALUES[i]) {
				number -= VALUES[i];
				result.append(ROMANS[i]);
			}
		}
		return result.toString();
	}

	public static String toRoman(Long number) {
		return toRoman(number.intValue());
	}

	public static String toRoman(String number) {
		if (number.matches("^[0-9]*$")) return toRoman(Integer.parseInt(number));
		throw new IllegalArgumentException("Invalid number");
	}

	public static int fromRoman(String roman) {
		if (roman == null || roman.isBlank()) throw new IllegalArgumentException("Roman numeral string cannot be null or empty");

		int total = 0;
		int prevValue = 0;

		for (int i = roman.length() - 1; i >= 0; i--) {
			char ch = roman.charAt(i);
			Integer value = ROMAN_MAP.get(ch);
			if (value == null) throw new IllegalArgumentException("Invalid Roman numeral character: " + ch);

			if (value < prevValue) total -= value;
			else {
				total += value;
				prevValue = value;
			}
		}

		return total;
	}

}