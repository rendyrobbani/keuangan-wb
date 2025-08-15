package com.rendyrobbani.keuangan.common.code.urusan;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UrusanCodeFactory {

	public static UrusanCode create(String code) {
		if (code == null) return null;
		if (!code.matches(UrusanCode.REGEX)) return null;
		return new UrusanCodeImpl(code);
	}

}