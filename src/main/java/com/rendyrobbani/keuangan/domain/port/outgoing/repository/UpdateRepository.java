package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface UpdateRepository<DOMAIN extends Data<ID>, ID> {

	DOMAIN update(ID id, DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy);

}