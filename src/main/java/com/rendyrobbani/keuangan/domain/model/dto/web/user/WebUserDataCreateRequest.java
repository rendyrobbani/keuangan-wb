package com.rendyrobbani.keuangan.domain.model.dto.web.user;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;

import java.time.LocalDate;

public interface WebUserDataCreateRequest {

	Nip nip();

	Pangkat pangkat();

	String name();

	String titlePrefix();

	String titleSuffix();

	LocalDate dateOfStart();

}