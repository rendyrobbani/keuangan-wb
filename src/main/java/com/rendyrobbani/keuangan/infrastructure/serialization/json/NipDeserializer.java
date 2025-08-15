package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.vo.NipFactory;

import java.io.IOException;

public class NipDeserializer extends JsonDeserializer<Nip> {

	@Override
	public Nip deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		var value = parser.getValueAsString();
		if (value == null) return null;
		return NipFactory.create(value);
	}

}