package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.application.web.record.user.validation.WebUserDataChangePasswordMustBeDifferent;
import com.rendyrobbani.keuangan.application.web.record.user.validation.WebUserDataChangePasswordMustBeNotDefault;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataChangePasswordRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@WebUserDataChangePasswordMustBeDifferent
@WebUserDataChangePasswordMustBeNotDefault
public record RecordOfWebUserDataChangePasswordRequest(@NotNull @NotBlank String oldPassword,
                                                       @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,16}$", message = "harus memiliki panjang 8-16 karakter dengan kombinasi huruf besar, huruf kecil, angka, dan karakter spesial")
                                                       @NotNull @NotBlank String newPassword) implements WebUserDataChangePasswordRequest {

}