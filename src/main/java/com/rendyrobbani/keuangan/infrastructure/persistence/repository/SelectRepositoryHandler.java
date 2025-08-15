package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.SelectRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractBaseEntity;

import java.util.List;

public interface SelectRepositoryHandler<ENTITY extends AbstractBaseEntity<DOMAIN, ID>, DOMAIN extends Base<ID>, ID> extends SelectRepository<DOMAIN, ID>,
                                                                                                                             BaseRepositoryHandler<ENTITY, DOMAIN, ID> {

	@Override
	default List<DOMAIN> selectAll() {
		return repository().findAll().stream().map(ENTITY::toDomain).toList();
	}

	@Override
	default DOMAIN selectById(ID id) {
		return repository().findById(id).map(ENTITY::toDomain).orElse(null);
	}

}