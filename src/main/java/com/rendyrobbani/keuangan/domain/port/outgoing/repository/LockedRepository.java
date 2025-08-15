package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Lock;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;

import java.time.LocalDateTime;

public interface LockedRepository<DOMAIN extends Lock<ID>, ID> {

	DOMAIN lock(ID id, LocalDateTime lockedAt, Nip lockedBy);

	DOMAIN unlock(ID id, LocalDateTime updatedAt, Nip updatedBy);

}