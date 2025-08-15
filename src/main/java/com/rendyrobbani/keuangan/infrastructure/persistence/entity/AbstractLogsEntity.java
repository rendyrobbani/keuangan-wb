package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.entity.Logs;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractLogsEntity<DOMAIN extends Logs<SUBJECT, SUBJECTID>, SUBJECT extends Data<SUBJECTID>, SUBJECTID> extends AbstractBaseEntity<DOMAIN, Long> implements Logs<SUBJECT, SUBJECTID> {

	@Column(name = "logged_at")
	protected LocalDateTime loggedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "logged_by")
	protected Nip loggedBy;

	public abstract void sync(SUBJECT domain);

	public void create(LocalDateTime createdAt, Nip createdBy) {
		this.loggedAt = createdAt;
		this.loggedBy = createdBy;
	}

}