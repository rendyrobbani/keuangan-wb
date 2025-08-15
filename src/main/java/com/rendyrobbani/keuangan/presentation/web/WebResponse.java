package com.rendyrobbani.keuangan.presentation.web;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.rendyrobbani.keuangan.domain.auth.WebJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebResponse {

	private final WebJwtService service;

	public ResponseEntity<?> error(int status, String message, Object errors) {
		var json = JsonNodeFactory.instance.objectNode();
		json.put("status", status);
		json.put("message", message);
		if (errors != null) json.putPOJO("errors", errors);

		var cookie = service.getTokenAsCookie();
		if (cookie != null && !cookie.isBlank()) return ResponseEntity.status(status).header("Set-Cookie", cookie).body(json);
		return ResponseEntity.status(status).body(json);
	}

	public ResponseEntity<?> error(int status, String message) {
		return error(status, message, null);
	}

	public ResponseEntity<?> success(String message, Object data) {
		var cookie = service.getTokenAsCookie();
		if (cookie != null && !cookie.isBlank() && data != null) return ResponseEntity.ok().header("Set-Cookie", cookie).body(data);

		if (data != null) {
			if (cookie != null && !cookie.isBlank()) return ResponseEntity.ok().header("Set-Cookie", cookie).body(data);
			return ResponseEntity.ok().body(data);
		}

		var json = JsonNodeFactory.instance.objectNode();
		json.put("status", 200);
		json.put("message", message != null ? message : "Ok");
		if (cookie != null && !cookie.isBlank()) return ResponseEntity.ok().header("Set-Cookie", cookie).body(json);
		return ResponseEntity.ok().body(json);
	}

	public ResponseEntity<?> success(Object data) {
		return this.success(null, data);
	}

}