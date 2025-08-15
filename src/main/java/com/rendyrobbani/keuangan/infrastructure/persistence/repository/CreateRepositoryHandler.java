package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.CreateRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractDataEntity;

import java.time.LocalDateTime;

public interface CreateRepositoryHandler<ENTITY extends AbstractDataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends CreateRepository<DOMAIN, ID>,
                                                                                                                             BaseRepositoryHandler<ENTITY, DOMAIN, ID> {

	ENTITY instance();

	@Override
	default DOMAIN create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy) {
		ENTITY entity;
		if (domain.id() != null) {
			entity = repository().findById(domain.id()).orElse(null);
			if (entity != null) {
				if (!entity.isDeleted()) throw new RuntimeException("Entity with id " + domain.id() + " already exists");
				entity.sync(domain);
				entity.revive(createdAt, createdBy);
				return repository().save(entity).toDomain();
			}
		}
		entity = instance();
		entity.create(domain, createdAt, createdBy);
		return repository().save(entity).toDomain();
	}

}