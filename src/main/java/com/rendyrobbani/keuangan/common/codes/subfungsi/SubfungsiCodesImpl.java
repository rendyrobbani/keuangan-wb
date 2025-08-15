package com.rendyrobbani.keuangan.common.codes.subfungsi;

import com.rendyrobbani.keuangan.common.codes.fungsi.FungsiCodes;

record SubfungsiCodesImpl(String fungsiCode,
                          String subfungsiCode) implements FungsiCodes,
                                                           SubfungsiCodes {

}