package com.rendyrobbani.keuangan.common.codes.bidang;

import com.rendyrobbani.keuangan.common.codes.urusan.UrusanCodes;

record BidangCodesImpl(String urusanCode,
                       String bidangCode) implements UrusanCodes,
                                                     BidangCodes {

}