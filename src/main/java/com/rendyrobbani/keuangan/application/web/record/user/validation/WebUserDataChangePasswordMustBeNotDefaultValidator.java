package com.rendyrobbani.keuangan.application.web.record.user.validation;

import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataChangePasswordRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class WebUserDataChangePasswordMustBeNotDefaultValidator implements ConstraintValidator<WebUserDataChangePasswordMustBeNotDefault, RecordOfWebUserDataChangePasswordRequest> {

	@Value("${com.rendyrobbani.keuangan.auth.default-password}")
	private String defaultPassword;

	@Override
	public boolean isValid(RecordOfWebUserDataChangePasswordRequest request, ConstraintValidatorContext context) {
		if (request.oldPassword() == null || request.newPassword() == null) return true;
		if (request.newPassword().equals(defaultPassword)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("tidak boleh sama dengan password default")
			       .addPropertyNode("newPassword")
			       .addConstraintViolation();
		}
		return !request.newPassword().equals(defaultPassword);
	}

}