package com.rendyrobbani.keuangan.application.web.record.auth;

import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.auth.WebAuthPreloginResponseOfRole;

import java.util.List;

public record RecordOfWebAuthPreloginResponse(String onlyName,
                                              String fullName,
                                              List<WebAuthPreloginResponseOfRole> roles) implements WebAuthPreloginResponse {

}