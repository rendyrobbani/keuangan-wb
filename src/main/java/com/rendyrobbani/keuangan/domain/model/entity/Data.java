package com.rendyrobbani.keuangan.domain.model.entity;

public interface Data<ID> extends Base<ID> {

	@Override
	ID id();

	boolean isDeleted();

	default boolean isNotDeleted() {
		return !this.isDeleted();
	}

}