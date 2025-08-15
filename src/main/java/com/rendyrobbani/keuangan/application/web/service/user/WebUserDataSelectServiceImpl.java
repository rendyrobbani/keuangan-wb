package com.rendyrobbani.keuangan.application.web.service.user;

import com.rendyrobbani.keuangan.application.web.mapper.user.WebUserDataMapper;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.port.incoming.web.user.WebUserDataSelectService;
import com.rendyrobbani.keuangan.domain.port.outgoing.repository.user.DataUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebUserDataSelectServiceImpl implements WebUserDataSelectService {

	private final WebJwtService webJwtService;

	private final DataUserRepository repository;

	@Override
	public List<WebUserDataSelectResponse> selectAll() {
		var response = repository.selectAll();
		if (webJwtService.isAdmin()) return response.stream().map(WebUserDataMapper::toSelectResponse).toList();
		return response.stream().filter(Data::isNotDeleted).map(WebUserDataMapper::toSelectResponse).toList();
	}

	@Override
	public WebUserDataDetailResponse selectById(String id) {
		var domain = repository.selectById(id);
		if (domain == null) throw new NotFoundException();
		if (domain.isDeleted() && !webJwtService.isAdmin()) throw new NotFoundException();
		return WebUserDataMapper.toDetailResponse(domain);
	}

}