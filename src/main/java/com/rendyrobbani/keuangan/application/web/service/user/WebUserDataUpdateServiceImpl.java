package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataUpdateRequest;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataUpdateService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserDataUpdateServiceImpl implements WebUserDataUpdateService {

	private final WebJwtService webJwtService;

	private final Validator validator;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	@Transactional
	public WebUserDataDetailResponse update(String id, WebUserDataUpdateRequest request) {
		var domain = dataRepository.selectById(id);
		if (domain == null) throw new NotFoundException();
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();

		var violations = validator.validate(request);
		if (!violations.isEmpty()) throw new BadRequestException(violations);
		else {
			var actionAt = LocalDateTime.now();
			var actionBy = webJwtService.getToken().user().nip();

			domain = WebUserDataMapper.toDomain(request, domain);
			domain = dataRepository.update(id, actionAt, actionBy, domain);
			logsRepository.create(domain, actionAt, actionBy);
			return WebUserDataMapper.toDetailResponse(domain);
		}
	}

}