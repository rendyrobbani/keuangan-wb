package com.rendyrobbani.keuangan.domain.auth;

import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Role;

public interface WebJwtPayload {

	Integer tahun();

	DataUser user();

	Role role();

}