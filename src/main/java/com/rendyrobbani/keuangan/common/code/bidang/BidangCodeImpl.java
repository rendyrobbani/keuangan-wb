package com.rendyrobbani.keuangan.common.code.bidang;

import com.rendyrobbani.keuangan.common.code.urusan.UrusanCode;

record BidangCodeImpl(String urusanCode,
                      String bidangCode) implements UrusanCode,
                                                    BidangCode {

}