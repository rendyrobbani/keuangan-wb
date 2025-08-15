package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	@Override
	public void serialize(LocalDateTime localDateTime, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (localDateTime == null) generator.writeNull();
		else generator.writeString(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

}