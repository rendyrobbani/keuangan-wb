package com.rendyrobbani.keuangan.domain.model.dto.web.user;

public interface WebUserDataSelectResponse {

	String id();

	String simpleNip();

	String styledNip();

	String pangkatValue();

	String pangkatTitle();

	String onlyName();

	String fullName();

	boolean isLocked();

	boolean isDeleted();

}