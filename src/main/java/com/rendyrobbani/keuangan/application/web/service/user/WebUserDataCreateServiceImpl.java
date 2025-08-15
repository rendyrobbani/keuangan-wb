package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataCreateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserDataCreateServiceImpl implements WebUserDataCreateService {

	@Value("${com.rendyrobbani.latte.auth.default-password}")
	private String defaultPassword;

	private final BCryptPasswordEncoder passwordEncoder;

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	@Transactional
	public WebUserDataDetailResponse create(WebUserDataCreateRequest request) {
		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var actionAt = LocalDateTime.now();
			var actionBy = webJwtService.getToken().user().nip();

			var domain = dataRepository.selectById(request.nip().simple());
			if (domain == null) {
				domain = WebUserDataMapper.toDomain(request, passwordEncoder.encode(defaultPassword));
				domain = dataRepository.create(domain, actionAt, actionBy);
				logsRepository.create(domain, actionAt, actionBy);
				return WebUserDataMapper.toDetailResponse(domain);
			}

			if (domain.isDeleted()) {
				domain = dataRepository.update(domain.id(), actionAt, actionBy, WebUserDataMapper.toDomain(request, passwordEncoder.encode(defaultPassword)));
				domain = dataRepository.revive(domain.id(), actionAt, actionBy);
				logsRepository.create(domain, actionAt, actionBy);
				return WebUserDataMapper.toDetailResponse(domain);
			} else {
				throw new BadRequestException("nip", "sudah digunakan");
			}
		}
	}

}