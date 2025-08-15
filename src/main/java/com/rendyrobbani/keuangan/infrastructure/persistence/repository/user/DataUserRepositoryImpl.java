package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.DataUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataUserRepositoryImpl implements DataUserRepository,
                                               SelectRepositoryHandler<DataUserEntity, DataUser, String>,
                                               CreateRepositoryHandler<DataUserEntity, DataUser, String>,
                                               UpdateRepositoryHandler<DataUserEntity, DataUser, String>,
                                               DeleteRepositoryHandler<DataUserEntity, DataUser, String>,
                                               LockedRepositoryHandler<DataUserEntity, DataUser, String> {

	private final DataUserJpaRepository repository;

	@Override
	public JpaRepository<DataUserEntity, String> repository() {
		return repository;
	}

	@Override
	public DataUserEntity instance() {
		return new DataUserEntity();
	}

}