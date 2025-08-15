package com.rendyrobbani.keuangan.presentation.api;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiResponse {

	public ResponseEntity<?> error(int status, String message, Object errors) {
		var json = JsonNodeFactory.instance.objectNode();
		json.put("status", status);
		json.put("message", message);
		if (errors != null) json.putPOJO("errors", errors);
		return ResponseEntity.status(status).body(json);
	}

	public ResponseEntity<?> error(int status, String message) {
		return error(status, message, null);
	}

	public ResponseEntity<?> success(String message, Object data) {
		if (data != null) return ResponseEntity.ok().body(data);
		var json = JsonNodeFactory.instance.objectNode();
		json.put("status", 200);
		json.put("message", message != null ? message : "Ok");
		return ResponseEntity.ok().body(json);
	}

	public ResponseEntity<?> success(Object data) {
		return this.success(null, data);
	}

}