package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.infrastructure.vo.PangkatEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class PangkatConverter implements AttributeConverter<Pangkat, String> {

	@Override
	public String convertToDatabaseColumn(Pangkat pangkat) {
		if (pangkat != null) return pangkat.value();
		return null;
	}

	@Override
	public Pangkat convertToEntityAttribute(String value) {
		if (value != null) return PangkatEnum.fromValue(value);
		return null;
	}

}