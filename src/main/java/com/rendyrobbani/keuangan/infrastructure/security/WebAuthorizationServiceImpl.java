package com.rendyrobbani.keuangan.infrastructure.security;

import com.rendyrobbani.keuangan.common.exception.http.ForbiddenException;
import com.rendyrobbani.keuangan.domain.auth.WebAuthorizationService;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebAuthorizationServiceImpl implements WebAuthorizationService {

	private final WebJwtService webJwtService;

	@Override
	public void hasInRole(List<Role> roles) {
		var role = webJwtService.getRole();
		if (role == null) throw new ForbiddenException();
		if (role.equals(RoleEnum.ADMIN)) return;
		if (roles.contains(role)) return;
		throw new ForbiddenException();
	}

}