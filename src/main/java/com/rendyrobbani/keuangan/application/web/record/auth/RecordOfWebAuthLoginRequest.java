package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginRequest;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import jakarta.validation.constraints.NotNull;

public record RecordOfWebAuthLoginRequest(@NotNull
                                          Role role) implements WebAuthLoginRequest {

}