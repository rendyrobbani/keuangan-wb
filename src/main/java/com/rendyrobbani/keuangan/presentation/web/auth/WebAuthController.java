package com.rendyrobbani.keuangan.presentation.web.auth;

import com.rendyrobbani.keuangan.application.web.record.auth.RecordOfWebAuthLoginRequest;
import com.rendyrobbani.keuangan.application.web.record.auth.RecordOfWebAuthPreloginRequest;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthLoginService;
import com.rendyrobbani.keuangan.domain.port.incoming.web.auth.WebAuthPreloginService;
import com.rendyrobbani.keuangan.presentation.web.WebResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebAuthController {

	private final WebResponse response;

	private final WebAuthPreloginService preloginService;

	private final WebAuthLoginService loginService;

	@PostMapping("/web/auth/prelogin")
	public ResponseEntity<?> prelogin(@RequestBody RecordOfWebAuthPreloginRequest request) {
		var response = preloginService.handle(request);
		return this.response.success(response);
	}

	@PostMapping("/web/auth/login")
	public ResponseEntity<?> login(@RequestBody RecordOfWebAuthLoginRequest request) {
		var response = loginService.handle(request);
		return this.response.success(response);
	}

}