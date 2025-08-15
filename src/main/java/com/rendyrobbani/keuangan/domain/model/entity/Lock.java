package com.rendyrobbani.keuangan.domain.model.entity;

public interface Lock<ID> extends Data<ID> {

	boolean isLocked();

}