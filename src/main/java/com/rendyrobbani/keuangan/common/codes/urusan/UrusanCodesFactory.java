package com.rendyrobbani.keuangan.common.codes.urusan;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrusanCodesFactory {

	public static UrusanCodes classify(String code) {
		if (code == null) return null;
		if (!code.matches(UrusanCodes.REGEX)) return null;
		return new UrusanCodesImpl(code);
	}

}