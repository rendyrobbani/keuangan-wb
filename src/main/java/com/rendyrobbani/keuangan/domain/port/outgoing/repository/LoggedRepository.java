package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.entity.Logs;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface LoggedRepository<DOMAIN extends Logs<SUBJECT, SUBJECTID>, SUBJECT extends Data<SUBJECTID>, SUBJECTID> {

	DOMAIN create(SUBJECT subject, LocalDateTime createdAt, Nip createdBy);

}