package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.model.entity.Logs;

import java.time.LocalDate;

public interface LogsUser extends Logs<DataUser, String> {

	@Override
	Long id();

	@Override
	String subjectId();

	@Override
	DataUser subject();

	Pangkat pangkat();

	String name();

	String titlePrefix();

	String titleSuffix();

	LocalDate dateOfBirth();

	LocalDate dateOfStart();

	Gender gender();

	Integer number();

	boolean isPNS();

	boolean isP3K();

	boolean isLocked();

	boolean isDeleted();

}