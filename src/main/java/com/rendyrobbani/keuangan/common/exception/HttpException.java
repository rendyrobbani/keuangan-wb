package com.rendyrobbani.keuangan.common.exception;

public abstract class HttpException extends RuntimeException {

	public abstract int status();

	public abstract String message();

}