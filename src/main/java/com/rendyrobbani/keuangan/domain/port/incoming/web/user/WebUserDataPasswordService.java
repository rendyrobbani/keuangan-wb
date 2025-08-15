package com.rendyrobbani.keuangan.domain.port.incoming.web.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataChangePasswordRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;

public interface WebUserDataPasswordService {

	WebUserDataDetailResponse change(String id, WebUserDataChangePasswordRequest request);

	WebUserDataDetailResponse revert(String id);

}