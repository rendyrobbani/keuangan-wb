package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthLoginResponse;

public record RecordOfWebAuthLoginResponse(String id,
                                           String simpleNip,
                                           String styledNip,
                                           String pangkatValue,
                                           String pangkatTitle,
                                           String onlyName,
                                           String fullName) implements WebAuthLoginResponse {

}