package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.entity.user.LogsUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.LogsUserEntity;
import com.rendyrobbani.keuangan.infrastructure.persistence.repository.LoggedRepositoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LogsUserRepositoryImpl implements LogsUserRepository,
                                               LoggedRepositoryHandler<LogsUserEntity, LogsUser, DataUser, String> {

	private final LogsUserJpaRepository repository;

	@Override
	public JpaRepository<LogsUserEntity, Long> repository() {
		return repository;
	}

	@Override
	public LogsUserEntity instance() {
		return new LogsUserEntity();
	}

}