package com.rendyrobbani.keuangan.application.web.record.user.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WebUserDataChangePasswordMustBeNotDefaultValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebUserDataChangePasswordMustBeNotDefault {

	String message() default "tidak boleh sama dengan password default";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}