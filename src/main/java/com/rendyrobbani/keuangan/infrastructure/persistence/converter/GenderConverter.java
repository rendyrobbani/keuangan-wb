package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.infrastructure.vo.GenderEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		if (gender != null) return gender.value();
		return null;
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		if (value != null) return GenderEnum.fromValue(value);
		return null;
	}

}