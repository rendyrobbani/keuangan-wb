package com.rendyrobbani.keuangan.presentation;

import com.rendyrobbani.keuangan.common.exception.http.BadRequestException;
import com.rendyrobbani.keuangan.common.exception.http.ForbiddenException;
import com.rendyrobbani.keuangan.common.exception.http.NotFoundException;
import com.rendyrobbani.keuangan.common.exception.http.UnauthorizedException;
import com.rendyrobbani.keuangan.presentation.api.ApiResponse;
import com.rendyrobbani.keuangan.presentation.web.WebResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorController {

	private final ApiResponse apiResponse;

	private final WebResponse webResponse;

	private ResponseEntity<?> handle(HttpServletRequest request, int status, String message, Object errors) {
		if (request.getRequestURI().startsWith("/api/")) return apiResponse.error(status, message, errors);
		if (request.getRequestURI().startsWith("/web/")) return webResponse.error(status, message, errors);
		return null;
	}

	private ResponseEntity<?> handle(HttpServletRequest request, int status, String message) {
		return handle(request, status, message, null);
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> handleBadRequestException(HttpServletRequest request, BadRequestException e) {
		return handle(request, e.status(), e.message(), e.errors());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<?> handleUnauthorizedException(HttpServletRequest request, UnauthorizedException e) {
		return handle(request, e.status(), e.message());
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<?> handleForbiddenException(HttpServletRequest request, ForbiddenException e) {
		return handle(request, e.status(), e.message());
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(HttpServletRequest request, NotFoundException e) {
		return handle(request, e.status(), e.message());
	}

}