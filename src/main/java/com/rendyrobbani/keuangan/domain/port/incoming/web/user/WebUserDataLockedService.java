package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;

public interface WebUserDataLockedService {

	WebUserDataDetailResponse lock(String id);

	WebUserDataDetailResponse unlock(String id);

}