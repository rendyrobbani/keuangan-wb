package com.rendyrobbani.keuangan.infrastructure.persistence.converter;

import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.vo.NipFactory;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public final class NipConverter implements AttributeConverter<Nip, String> {

	@Override
	public String convertToDatabaseColumn(Nip nip) {
		if (nip != null) return nip.simple();
		return null;
	}

	@Override
	public Nip convertToEntityAttribute(String value) {
		if (value != null) return NipFactory.create(value);
		return null;
	}

}