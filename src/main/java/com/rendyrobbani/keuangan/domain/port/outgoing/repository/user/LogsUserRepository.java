package com.rendyrobbani.keuangan.domain.port.outgoing.repository.user;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.entity.user.LogsUser;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.LoggedRepository;

public interface LogsUserRepository extends LoggedRepository<LogsUser, DataUser, String> {

}