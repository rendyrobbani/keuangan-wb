package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;

import java.util.List;

public interface WebUserDataSelectService {

	List<WebUserDataSelectResponse> selectAll();

	WebUserDataDetailResponse selectById(String id);

}