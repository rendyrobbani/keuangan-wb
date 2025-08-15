package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.infrastructure.vo.GenderEnum;

import java.io.IOException;

public class GenderDeserializer extends JsonDeserializer<Gender> {

	@Override
	public Gender deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		var value = parser.getValueAsInt();
		return GenderEnum.fromValue(value);
	}

}