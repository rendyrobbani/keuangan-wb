package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		var value = parser.getValueAsString();
		if (value == null) return null;
		return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
	}

}