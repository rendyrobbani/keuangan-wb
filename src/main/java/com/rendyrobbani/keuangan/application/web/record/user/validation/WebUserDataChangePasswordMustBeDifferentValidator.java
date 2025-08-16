package com.rendyrobbani.keuangan.application.web.record.user.validation;

import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataChangePasswordRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WebUserDataChangePasswordMustBeDifferentValidator implements ConstraintValidator<WebUserDataChangePasswordMustBeDifferent, RecordOfWebUserDataChangePasswordRequest> {

	@Override
	public boolean isValid(RecordOfWebUserDataChangePasswordRequest request, ConstraintValidatorContext context) {
		if (request.oldPassword() == null || request.newPassword() == null) return true;
		if (request.oldPassword().equals(request.newPassword())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("tidak boleh sama dengan password lama")
			       .addPropertyNode("oldPassword")
			       .addConstraintViolation();
		}
		return true;
	}

}