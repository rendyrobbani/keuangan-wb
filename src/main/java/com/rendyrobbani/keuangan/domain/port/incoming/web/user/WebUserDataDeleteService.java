package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;

public interface WebUserDataDeleteService {

	WebUserDataDetailResponse delete(String id);

	WebUserDataDetailResponse revive(String id);

}