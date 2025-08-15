package com.rendyrobbani.keuangan.common.exception.http;

import com.rendyrobbani.keuangan.common.exception.HttpException;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = false, fluent = true)
public class ForbiddenException extends HttpException {

	private static final int DEFAULT_STATUS = 403;

	private static final String DEFAULT_MESSAGE = "Forbidden";

	private final int status;

	private final String message;

	public ForbiddenException() {
		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
	}

	public ForbiddenException(String message) {
		this.status = DEFAULT_STATUS;
		this.message = message;
	}

}