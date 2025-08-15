package com.rendyrobbani.keuangan.common.codes.fungsi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FungsiCodesFactory {

	public static FungsiCodes classify(String code) {
		if (code == null) return null;
		if (!code.matches(FungsiCodes.REGEX)) return null;
		return new FungsiCodesImpl(code);
	}

}