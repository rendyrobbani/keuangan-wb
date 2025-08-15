package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.UpdateRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractDataEntity;

import java.time.LocalDateTime;

public interface UpdateRepositoryHandler<ENTITY extends AbstractDataEntity<DOMAIN, ID>, DOMAIN extends Data<ID>, ID> extends UpdateRepository<DOMAIN, ID>,
                                                                                                                             BaseRepositoryHandler<ENTITY, DOMAIN, ID> {

	@Override
	default DOMAIN update(ID id, LocalDateTime updatedAt, Nip updatedBy, DOMAIN domain) {
		ENTITY entity = repository().findById(id).orElse(null);
		if (entity == null) throw new RuntimeException("Entity with id " + id + " not found");
		entity.update(domain, updatedAt, updatedBy);
		return repository().save(entity).toDomain();
	}

}