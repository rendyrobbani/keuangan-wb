package com.rendyrobbani.keuangan.application.web.record.user;

import com.rendyrobbani.keuangan.domain.model.dto.web.user.WebUserDataCreateRequest;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RecordOfWebUserDataCreateRequest(@NotNull Nip nip,
                                               @NotNull Pangkat pangkat,
                                               @NotNull @NotBlank String name,
                                               String titlePrefix,
                                               String titleSuffix,
                                               @NotNull LocalDate dateOfStart) implements WebUserDataCreateRequest {

}