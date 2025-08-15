package com.rendyrobbani.keuangan.common.codes.bidang;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BidangCodesFactory {

	public static BidangCodes classify(String code) {
		if (code == null) return null;
		if (!code.matches(BidangCodes.REGEX)) return null;
		var codes = code.split("\\.");
		return new BidangCodesImpl(codes[0], codes[1]);
	}

}