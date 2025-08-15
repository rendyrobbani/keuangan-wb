package com.rendyrobbani.keuangan.domain.port.incoming.web.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginResponse;

public interface WebAuthLoginService {

	WebAuthLoginResponse handle(WebAuthLoginRequest request);

}