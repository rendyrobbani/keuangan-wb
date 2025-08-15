package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;

public record RecordOfWebUserDataSelectResponse(String id,
                                                String simpleNip,
                                                String styledNip,
                                                String pangkatValue,
                                                String pangkatTitle,
                                                String onlyName,
                                                String fullName,
                                                boolean isLocked,
                                                boolean isDeleted) implements WebUserDataSelectResponse {

}