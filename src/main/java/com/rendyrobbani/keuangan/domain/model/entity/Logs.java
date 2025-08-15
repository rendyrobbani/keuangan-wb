package com.rendyrobbani.keuangan.domain.model.entity;

public interface Logs<SUBJECT extends Data<SUBJECTID>, SUBJECTID> extends Base<Long> {

	@Override
	Long id();

	SUBJECTID subjectId();

	SUBJECT subject();

}