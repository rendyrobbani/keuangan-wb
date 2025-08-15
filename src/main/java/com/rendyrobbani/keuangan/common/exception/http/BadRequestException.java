package com.rendyrobbani.keuangan.common.exception.http;

import com.rendyrobbani.keuangan.common.exception.HttpException;
import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.*;

@Getter
@Accessors(chain = false, fluent = true)
public class BadRequestException extends HttpException {

	private static final int DEFAULT_STATUS = 400;

	private static final String DEFAULT_MESSAGE = "Bad Request";

	private final int status;

	private final String message;

	private final Map<String, List<String>> errors;

	public BadRequestException() {
		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
		this.errors = null;
	}

	public BadRequestException(String message) {
		this.status = DEFAULT_STATUS;
		this.message = message;
		this.errors = null;
	}

	public BadRequestException(Map<String, List<String>> errors) {
		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
		this.errors = errors;
	}

	public BadRequestException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		var errors = new HashMap<String, List<String>>();
		for (var violation : constraintViolations) {
			var messages = errors.getOrDefault(violation.getPropertyPath().toString(), new ArrayList<>());
			if (!messages.contains(violation.getMessage())) {
				messages.add(violation.getMessage());
				errors.put(violation.getPropertyPath().toString(), messages);
			}
		}

		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
		this.errors = errors;
	}

}