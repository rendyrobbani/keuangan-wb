package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataLockedService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.LogsUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WebUserDataLockedServiceImpl implements WebUserDataLockedService {

	private final WebJwtService webJwtService;

	private final DataUserRepository dataRepository;

	private final LogsUserRepository logsRepository;

	@Override
	@Transactional
	public WebUserDataDetailResponse lock(String id) {
		var domain = dataRepository.selectById(id);
		if (domain == null) throw new NotFoundException();
		if (domain.isLocked()) return WebUserDataMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();
		domain = dataRepository.lock(id, actionAt, actionBy);
		logsRepository.create(domain, actionAt, actionBy);
		return WebUserDataMapper.toDetailResponse(domain);
	}

	@Override
	@Transactional
	public WebUserDataDetailResponse unlock(String id) {
		var domain = dataRepository.selectById(id);
		if (domain == null) throw new NotFoundException();
		if (!domain.isLocked()) return WebUserDataMapper.toDetailResponse(domain);

		var actionAt = LocalDateTime.now();
		var actionBy = webJwtService.getToken().user().nip();
		domain = dataRepository.unlock(id, actionAt, actionBy);
		logsRepository.create(domain, actionAt, actionBy);
		return WebUserDataMapper.toDetailResponse(domain);
	}

}