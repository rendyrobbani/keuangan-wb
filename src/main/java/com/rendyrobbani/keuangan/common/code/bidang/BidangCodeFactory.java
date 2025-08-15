package com.rendyrobbani.keuangan.common.code.bidang;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BidangCodeFactory {

	public static BidangCode create(String code) {
		if (code == null) return null;
		if (!code.matches(BidangCode.REGEX)) return null;
		var codes = code.split("\\.");
		return new BidangCodeImpl(codes[0], codes[1]);
	}

}