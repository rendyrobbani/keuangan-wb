package com.rendyrobbani.keuangan.application.web.service.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.RecordOfWebAuthLoginResponse;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginResponse;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthLoginService;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebAuthLoginServiceImpl implements WebAuthLoginService {

	private final DataUser admin;

	private final WebJwtService webJwtService;

	@Override
	public WebAuthLoginResponse handle(WebAuthLoginRequest request) {
		return switch (request.role()) {
			case RoleEnum.ADMIN -> loginAsAdministrator();
			default -> throw new UnauthorizedException();
		};
	}

	private WebAuthLoginResponse loginAsAdministrator() {
		var user = webJwtService.getUser();
		if (user.id().equals(admin.id())) {
			webJwtService.setToken(user, RoleEnum.ADMIN);
			return toResponse(user);
		}
		throw new UnauthorizedException();
	}

	private WebAuthLoginResponse toResponse(DataUser user) {
		return new RecordOfWebAuthLoginResponse(user.id(),
		                                        user.simpleNip(),
		                                        user.styledNip(),
		                                        user.pangkatValue(),
		                                        user.pangkatTitle(),
		                                        user.onlyName(false),
		                                        user.fullName(false));
	}

}