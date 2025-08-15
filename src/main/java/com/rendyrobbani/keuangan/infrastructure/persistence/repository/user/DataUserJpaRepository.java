package com.rendyrobbani.keuangan.infrastructure.persistence.repository.user;

import com.rendyrobbani.keuangan.infrastructure.persistence.entity.user.DataUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUserJpaRepository extends JpaRepository<DataUserEntity, String> {

}