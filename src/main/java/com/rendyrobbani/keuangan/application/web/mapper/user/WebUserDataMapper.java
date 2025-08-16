package com.rendyrobbani.keuangan.application.web.mapper.user;

import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserData;
import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataDetailResponse;
import com.rendyrobbani.keuangan.application.web.record.user.RecordOfWebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataDetailResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataSelectResponse;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebUserDataMapper {

	public static WebUserDataSelectResponse toSelectResponse(DataUser user) {
		return new RecordOfWebUserDataSelectResponse(user.id(),
		                                             user.simpleNip(),
		                                             user.styledNip(),
		                                             user.pangkatValue(),
		                                             user.pangkatTitle(),
		                                             user.onlyName(false),
		                                             user.fullName(false),
		                                             user.isLocked(),
		                                             user.isDeleted());
	}

	public static WebUserDataDetailResponse toDetailResponse(DataUser user) {
		return new RecordOfWebUserDataDetailResponse(user.id(),
		                                             user.simpleNip(),
		                                             user.styledNip(),
		                                             user.pangkatValue(),
		                                             user.pangkatTitle(),
		                                             user.onlyName(false),
		                                             user.fullName(false),
		                                             user.titlePrefix(),
		                                             user.titleSuffix(),
		                                             user.dateOfBirth(),
		                                             user.dateOfStart(),
		                                             user.gender(),
		                                             user.number(),
		                                             user.isPNS(),
		                                             user.isP3K(),
		                                             user.isLocked(),
		                                             user.isDeleted());
	}

	public static DataUser toDomain(WebUserDataCreateRequest request, String password) {
		return new RecordOfWebUserData(request.nip().simple(),
		                               request.nip(),
		                               request.pangkat(),
		                               request.name(),
		                               request.titlePrefix(),
		                               request.titleSuffix(),
		                               password,
		                               request.nip().dateOfBirth(),
		                               request.pangkat().isPNS() ? request.nip().dateOfStart() : request.dateOfStart(),
		                               request.nip().gender(),
		                               request.nip().number(),
		                               request.pangkat().isPNS(),
		                               request.pangkat().isP3K(),
		                               false,
		                               false
		);
	}

	public static DataUser toDomain(WebUserDataUpdateRequest request, DataUser domain) {
		return new RecordOfWebUserData(domain.nip().simple(),
		                               domain.nip(),
		                               request.pangkat(),
		                               request.name(),
		                               request.titlePrefix(),
		                               request.titleSuffix(),
		                               domain.password(),
		                               domain.nip().dateOfBirth(),
		                               request.pangkat().isPNS() ? domain.nip().dateOfStart() : request.dateOfStart(),
		                               domain.nip().gender(),
		                               domain.nip().number(),
		                               request.pangkat().isPNS(),
		                               request.pangkat().isP3K(),
		                               domain.isLocked(),
		                               domain.isDeleted()
		);
	}

	public static DataUser toDomain(DataUser user, String password) {
		return new RecordOfWebUserData(user.nip().simple(),
		                               user.nip(),
		                               user.pangkat(),
		                               user.name(),
		                               user.titlePrefix(),
		                               user.titleSuffix(),
		                               password,
		                               user.nip().dateOfBirth(),
		                               user.pangkat().isPNS() ? user.nip().dateOfStart() : user.dateOfStart(),
		                               user.nip().gender(),
		                               user.nip().number(),
		                               user.pangkat().isPNS(),
		                               user.pangkat().isP3K(),
		                               user.isLocked(),
		                               user.isDeleted()
		);
	}

}