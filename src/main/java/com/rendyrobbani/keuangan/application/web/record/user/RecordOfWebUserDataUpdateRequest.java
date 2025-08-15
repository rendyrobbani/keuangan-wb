package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.common.util.text.TextUtil;
import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataUpdateRequest;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RecordOfWebUserDataUpdateRequest(@NotNull Pangkat pangkat,
                                               @NotNull @NotBlank String name,
                                               String titlePrefix,
                                               String titleSuffix,
                                               @NotNull LocalDate dateOfStart) implements WebUserDataUpdateRequest {

	@Override
	public String name() {
		return TextUtil.trim(name);
	}

	@Override
	public String titlePrefix() {
		return TextUtil.trim(titlePrefix);
	}

	@Override
	public String titleSuffix() {
		return TextUtil.trim(titleSuffix);
	}

}