package com.rendyrobbani.keuangan.infrastructure.vo;

import com.rendyrobbani.keuangan.domain.model.vo.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum implements Role {
	ADMIN(1, "Administrator"),
	SEKDA(2, "Sekretaris Daerah"),
	PPKD(3, "Pejabat Pengelola Keuangan Daerah"),
	TAPD(4, "Tim Anggaran Pemerintah Daerah");

	private final Integer value;

	private final String title;

	public static Role fromValue(Integer value) {
		if (value != null) for (var e : values()) if (e.value().equals(value)) return e;
		return null;
	}
}