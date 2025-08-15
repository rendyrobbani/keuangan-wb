package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Base;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractBaseEntity<DOMAIN extends Base<ID>, ID> implements Base<ID>,
                                                                                 Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	public abstract DOMAIN toDomain();

}