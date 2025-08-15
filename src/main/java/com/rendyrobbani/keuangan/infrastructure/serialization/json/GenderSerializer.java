package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;

import java.io.IOException;

public class GenderSerializer extends JsonSerializer<Gender> {

	@Override
	public void serialize(Gender gender, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (gender == null) generator.writeNull();
		else generator.writeNumber(gender.value());
	}

}