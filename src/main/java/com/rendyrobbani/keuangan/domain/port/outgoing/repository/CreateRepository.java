package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface CreateRepository<DOMAIN extends Data<ID>, ID> {

	DOMAIN create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy);

}