package com.rendyrobbani.keuangan.common.codes.bidang;

import com.rendyrobbani.keuangan.common.codes.urusan.UrusanCodes;

public interface BidangCodes extends UrusanCodes {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})$";

	String bidangCode();

}