package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RecordOfWebAuthPreloginRequest(@NotNull @NotBlank String username,
                                             @NotNull @NotBlank String password) implements WebAuthPreloginRequest {

}