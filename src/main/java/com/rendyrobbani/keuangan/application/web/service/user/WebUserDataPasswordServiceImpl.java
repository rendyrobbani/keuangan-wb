package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataChangePasswordRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataPasswordService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserDataPasswordServiceImpl implements WebUserDataPasswordService {

	@Value("${com.rendyrobbani.keuangan.auth.default-password}")
	private String defaultPassword;

	private final BCryptPasswordEncoder passwordEncoder;

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	@Transactional
	public WebUserDataDetailResponse change(String id, WebUserDataChangePasswordRequest request) {
		var user = dataRepository.selectById(id);
		if (user == null) throw new NotFoundException();
		if (user.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();

		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);

		var errors = new HashMap<String, List<String>>();
		if (!passwordEncoder.matches(request.oldPassword(), user.password())) throw new BadRequestException("oldPassword", "salah");

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getUser().nip();

		user = WebUserDataMapper.toDomain(user, passwordEncoder.encode(defaultPassword));
		user = dataRepository.update(id, actionAt, actionBy, user);
		logsRepository.create(user, actionAt, actionBy);
		return WebUserDataMapper.toDetailResponse(user);
	}

	@Override
	@Transactional
	public WebUserDataDetailResponse revert(String id) {
		var user = dataRepository.selectById(id);
		if (user == null) throw new NotFoundException();
		if (user.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getUser().nip();

		user = WebUserDataMapper.toDomain(user, passwordEncoder.encode(defaultPassword));
		user = dataRepository.update(id, actionAt, actionBy, user);
		logsRepository.create(user, actionAt, actionBy);
		return WebUserDataMapper.toDetailResponse(user);
	}

}