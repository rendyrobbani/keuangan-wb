package com.rendyrobbani.keuangan.domain.model.entity.user;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.model.marker.HasNameAndTitles;
import com.rendyrobbani.keuangan.domain.model.marker.HasNip;
import com.rendyrobbani.keuangan.domain.model.marker.HasPangkat;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDate;

public interface DataUser extends Lock<String>,
                                  HasNip,
                                  HasPangkat,
                                  HasNameAndTitles {

	@Override
	String id();

	@Override
	Nip nip();

	@Override
	Pangkat pangkat();

	@Override
	String name();

	@Override
	String titlePrefix();

	@Override
	String titleSuffix();

	String password();

	LocalDate dateOfBirth();

	LocalDate dateOfStart();

	Gender gender();

	Integer number();

	boolean isPNS();

	boolean isP3K();

	@Override
	boolean isLocked();

	@Override
	boolean isDeleted();

}