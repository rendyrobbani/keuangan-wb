package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.DeleteRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractDataEntity;

import java.time.LocalDateTime;

public interface DeleteRepositoryHandler<ENTITY extends AbstractDataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends DeleteRepository<DOMAIN, ID>,
                                                                                                                             BaseRepositoryHandler<ENTITY, DOMAIN, ID> {

	@Override
	default DOMAIN delete(ID id, LocalDateTime deletedAt, Nip deletedBy) {
		ENTITY entity = repository().findById(id).orElse(null);
		if (entity == null) throw new RuntimeException("Entity with id " + id + " not found");
		if (entity.isDeleted()) return entity.toDomain();
		entity.delete(deletedAt, deletedBy);
		return repository().save(entity).toDomain();
	}

	@Override
	default DOMAIN revive(ID id, LocalDateTime updatedAt, Nip updatedBy) {
		ENTITY entity = repository().findById(id).orElse(null);
		if (entity == null) throw new RuntimeException("Entity with id " + id + " not found");
		if (!entity.isDeleted()) return entity.toDomain();
		entity.revive(updatedAt, updatedBy);
		return repository().save(entity).toDomain();
	}

}