package com.rendyrobbani.keuangan.domain.port.incoming.web.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;

public interface WebAuthPreloginService {

	WebAuthPreloginResponse handle(WebAuthPreloginRequest request);

}