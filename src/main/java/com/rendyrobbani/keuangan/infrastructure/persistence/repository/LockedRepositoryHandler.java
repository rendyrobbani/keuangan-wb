package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.LockedRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractLockEntity;

import java.time.LocalDateTime;

public interface LockedRepositoryHandler<ENTITY extends AbstractLockEntity<DOMAIN, ID>, DOMAIN extends Lock<ID>, ID> extends LockedRepository<DOMAIN, ID>,
                                                                                                                             BaseRepositoryHandler<ENTITY, DOMAIN, ID> {

	@Override
	default DOMAIN lock(ID id, LocalDateTime lockedAt, Nip lockedBy) {
		ENTITY entity = repository().findById(id).orElse(null);
		if (entity == null) throw new RuntimeException("Entity with id " + id + " not found");
		if (entity.isLocked()) return entity.toDomain();
		entity.lock(lockedAt, lockedBy);
		return repository().save(entity).toDomain();
	}

	@Override
	default DOMAIN unlock(ID id, LocalDateTime updatedAt, Nip updatedBy) {
		ENTITY entity = repository().findById(id).orElse(null);
		if (entity == null) throw new RuntimeException("Entity with id " + id + " not found");
		if (!entity.isLocked()) return entity.toDomain();
		entity.unlock(updatedAt, updatedBy);
		return repository().save(entity).toDomain();
	}

}