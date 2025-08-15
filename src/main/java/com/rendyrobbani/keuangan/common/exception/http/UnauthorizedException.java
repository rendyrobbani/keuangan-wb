package com.rendyrobbani.keuangan.common.exception.http;

import com.rendyrobbani.keuangan.common.exception.HttpException;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = false, fluent = true)
public class UnauthorizedException extends HttpException {

	private static final int DEFAULT_STATUS = 401;

	private static final String DEFAULT_MESSAGE = "Unauthorized";

	private final int status;

	private final String message;

	public UnauthorizedException() {
		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
	}

	public UnauthorizedException(String message) {
		this.status = DEFAULT_STATUS;
		this.message = message;
	}

}