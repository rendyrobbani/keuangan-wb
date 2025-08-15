package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.infrastructure.vo.PangkatEnum;

import java.io.IOException;

public class PangkatDeserializer extends JsonDeserializer<Pangkat> {

	@Override
	public Pangkat deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		var value = parser.getValueAsString();
		if (value == null) return null;
		return PangkatEnum.fromValue(value);
	}

}