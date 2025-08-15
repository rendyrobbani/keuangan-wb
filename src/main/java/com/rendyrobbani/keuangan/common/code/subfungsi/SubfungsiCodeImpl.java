package com.rendyrobbani.keuangan.common.code.subfungsi;

import com.rendyrobbani.keuangan.common.code.fungsi.FungsiCode;

record SubfungsiCodeImpl(String fungsiCode,
                         String subfungsiCode) implements FungsiCode,
                                                          SubfungsiCode {

}