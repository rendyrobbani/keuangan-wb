package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface DeleteRepository<DOMAIN extends Data<ID>, ID> {

	DOMAIN delete(ID id, LocalDateTime deletedAt, Nip deletedBy);

	DOMAIN revive(ID id, LocalDateTime updatedAt, Nip updatedBy);

}