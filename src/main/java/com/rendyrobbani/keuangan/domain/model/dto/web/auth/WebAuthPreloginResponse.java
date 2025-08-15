package com.rendyrobbani.keuangan.domain.model.dto.web.auth;

import java.util.List;

public interface WebAuthPreloginResponse {

	String onlyName();

	String fullName();

	List<WebAuthPreloginResponseOfRole> roles();

}