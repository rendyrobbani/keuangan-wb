package com.rendyrobbani.keuangan.common.exception.http;

import com.rendyrobbani.keuangan.common.exception.HttpException;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = false, fluent = true)
public class NotFoundException extends HttpException {

	private static final int DEFAULT_STATUS = 404;

	private static final String DEFAULT_MESSAGE = "Not Found";

	private final int status;

	private final String message;

	public NotFoundException() {
		this.status = DEFAULT_STATUS;
		this.message = DEFAULT_MESSAGE;
	}

	public NotFoundException(String message) {
		this.status = DEFAULT_STATUS;
		this.message = message;
	}

}