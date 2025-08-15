package com.rendyrobbani.keuangan.infrastructure.persistence.factory;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NipFactory {

	private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyyMMdd");

	public static Nip create(String value) {
		if (value != null && value.matches(Nip.REGEX)) {
			var dateOfBirth = value.substring(0, 8);
			var dateOfStart = value.substring(8, 14);
			var gender = value.substring(14, 15);
			var number = value.substring(15);

			return new NipRecord(value,
			                     String.join(" ", dateOfBirth, dateOfStart, gender, number),
			                     LocalDate.parse(dateOfBirth, PATTERN),
			                     dateOfStart.endsWith("21") ? null : LocalDate.parse(dateOfStart + "01", PATTERN),
			                     GenderEnum.fromValue(gender),
			                     Integer.valueOf(number)
			);
		}
		return null;
	}

}