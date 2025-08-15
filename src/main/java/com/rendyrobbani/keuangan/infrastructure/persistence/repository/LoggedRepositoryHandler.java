package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.entity.Logs;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.LoggedRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractLogsEntity;

import java.time.LocalDateTime;

public interface LoggedRepositoryHandler<ENTITY extends AbstractLogsEntity<DOMAIN, SUBJECT, SUBJECTID>, DOMAIN extends Logs<SUBJECT, SUBJECTID>, SUBJECT extends Data<SUBJECTID>, SUBJECTID> extends LoggedRepository<DOMAIN, SUBJECT, SUBJECTID>,
                                                                                                                                                                                                     BaseRepositoryHandler<ENTITY, DOMAIN, Long> {

	ENTITY instance();

	@Override
	default DOMAIN create(SUBJECT domain, LocalDateTime createdAt, Nip createdBy) {
		ENTITY entity = instance();
		entity.sync(domain);
		entity.create(createdAt, createdBy);
		return repository().save(entity).toDomain();
	}

}