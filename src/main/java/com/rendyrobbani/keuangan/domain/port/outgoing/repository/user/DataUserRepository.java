package com.rendyrobbani.keuangan.domain.port.outgoing.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.*;

import java.time.LocalDateTime;
import java.util.List;

public interface DataUserRepository extends SelectRepository<DataUser, String>,
                                            CreateRepository<DataUser, String>,
                                            UpdateRepository<DataUser, String>,
                                            DeleteRepository<DataUser, String>,
                                            LockedRepository<DataUser, String> {

	@Override
	List<DataUser> selectAll();

	@Override
	DataUser selectById(String id);

	@Override
	DataUser create(DataUser dataUser, LocalDateTime createdAt, Nip createdBy);

	@Override
	DataUser update(String id, DataUser dataUser, LocalDateTime updatedAt, Nip updatedBy);

	@Override
	DataUser delete(String id, LocalDateTime deletedAt, Nip deletedBy);

	@Override
	DataUser revive(String id, LocalDateTime updatedAt, Nip updatedBy);

	@Override
	DataUser lock(String id, LocalDateTime lockedAt, Nip lockedBy);

	@Override
	DataUser unlock(String id, LocalDateTime updatedAt, Nip updatedBy);

}