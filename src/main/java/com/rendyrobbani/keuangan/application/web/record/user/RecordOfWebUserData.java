package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;

import java.time.LocalDate;

public record RecordOfWebUserData(String id,
                                  Nip nip,
                                  Pangkat pangkat,
                                  String name,
                                  String titlePrefix,
                                  String titleSuffix,
                                  String password,
                                  LocalDate dateOfBirth,
                                  LocalDate dateOfStart,
                                  Gender gender,
                                  Integer number,
                                  boolean isPNS,
                                  boolean isP3K,
                                  boolean isLocked,
                                  boolean isDeleted) implements DataUser {

}