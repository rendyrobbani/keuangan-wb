package com.rendyrobbani.keuangan.common.code.bidang;

import com.rendyrobbani.keuangan.common.code.urusan.UrusanCode;

public interface BidangCode extends UrusanCode {

	String REGEX = "^(?!0.*|.\\.0{2}.*|X\\.\\d{2}.*|\\d\\.X{2}.*)(X|\\d)\\.(XX|\\d{2})$";

	String bidangCode();

}