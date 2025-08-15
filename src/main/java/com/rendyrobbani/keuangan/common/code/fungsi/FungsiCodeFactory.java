package com.rendyrobbani.keuangan.common.code.fungsi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FungsiCodeFactory {

	public static FungsiCode create(String code) {
		if (code == null) return null;
		if (!code.matches(FungsiCode.REGEX)) return null;
		return new FungsiCodeImpl(code);
	}

}