package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;

public record RecordOfWebAuthPreloginResponseOfRole(Integer role,
                                                    String name) implements WebAuthPreloginResponseOfRole {

}