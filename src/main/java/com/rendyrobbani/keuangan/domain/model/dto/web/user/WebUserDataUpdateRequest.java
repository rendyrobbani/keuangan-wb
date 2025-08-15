package com.rendyrobbani.keuangan.domain.model.dto.web.user;

import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;

import java.time.LocalDate;

public interface WebUserDataUpdateRequest {

	Pangkat pangkat();

	String name();

	String titlePrefix();

	String titleSuffix();

	LocalDate dateOfStart();

}