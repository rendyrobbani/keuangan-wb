package com.rendyrobbani.keuangan.infrastructure.vo;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDate;

record NipRecord(String simple,
                 String styled,
                 LocalDate dateOfBirth,
                 LocalDate dateOfStart,
                 Gender gender,
                 Integer number) implements Nip {

}