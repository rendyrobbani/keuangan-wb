package com.rendyrobbani.keuangan.domain.model.entity;

public interface Logs<SUBJECT extends Data<SUBJECTID>, SUBJECTID> {

	Long id();

	SUBJECTID subjectId();

	SUBJECT subject();

}