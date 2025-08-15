package com.rendyrobbani.keuangan.application.web.service.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.RecordOfWebAuthPreloginResponse;
import com.rendyrobbani.keuangan.application.web.record.auth.RecordOfWebAuthPreloginResponseOfRole;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthPreloginService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.infrastructure.config.WebAdminConfig;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class WebAuthPreloginServiceImpl implements WebAuthPreloginService {

	@Value("${com.rendyrobbani.latte.auth.default-password}")
	private String defaultPassword;

	private final DataUser admin;

	private final BCryptPasswordEncoder passwordEncoder;

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataUserRepository userRepository;

	@Override
	public WebAuthPreloginResponse handle(WebAuthPreloginRequest request) {
		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var isAdmin = request.username().equals(admin.id());

			var user = userRepository.selectById(request.username());
			if (user == null) throw new UnauthorizedException();
			if (user.isLocked() && !isAdmin) throw new UnauthorizedException();
			if (user.isDeleted() && !isAdmin) throw new UnauthorizedException();

			if (isAdmin) {
				var check1 = passwordEncoder.matches(request.username(), WebAdminConfig.ADMIN_PASSWORD);
				var check2 = passwordEncoder.matches(request.password(), user.password());
				if (!check1 && !check2) throw new UnauthorizedException();
			} else {
				if (!passwordEncoder.matches(request.password(), user.password())) throw new UnauthorizedException();
			}

			var roles = new ArrayList<WebAuthPreloginResponseOfRole>();
			if (isAdmin) roles.add(toResponseOfRole(RoleEnum.ADMIN));

			if (roles.isEmpty()) throw new UnauthorizedException();
			webJwtService.setToken(user);

			if (request.password().equals(defaultPassword)) roles.clear();

			return new RecordOfWebAuthPreloginResponse(user.onlyName(false), user.fullName(false), roles);
		}
	}

	private WebAuthPreloginResponseOfRole toResponseOfRole(Role role) {
		return new RecordOfWebAuthPreloginResponseOfRole(role.value(), role.title());
	}

}