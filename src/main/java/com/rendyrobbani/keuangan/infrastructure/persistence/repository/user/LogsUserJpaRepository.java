package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.LogsUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsUserJpaRepository extends JpaRepository<LogsUserEntity, Long> {

}