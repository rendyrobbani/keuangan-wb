package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

	@Override
	public void serialize(LocalDate localDate, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (localDate == null) generator.writeNull();
		else generator.writeString(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
	}

}