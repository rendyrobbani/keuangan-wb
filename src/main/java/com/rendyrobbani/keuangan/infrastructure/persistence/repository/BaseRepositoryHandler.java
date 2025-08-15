package com.rendyrobbani.keuangan.infrastructure.persistence.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepositoryHandler<ENTITY extends AbstractBaseEntity<DOMAIN, ID>, DOMAIN extends Base<ID>, ID> {

	JpaRepository<ENTITY, ID> repository();

}