package com.rendyrobbani.keuangan.infrastructure.serialization.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.infrastructure.vo.RoleEnum;

import java.io.IOException;

public class RoleDeserializer extends JsonDeserializer<Role> {

	@Override
	public Role deserialize(JsonParser parser, DeserializationContext context) throws IOException {
		var value = parser.getValueAsInt();
		return RoleEnum.fromValue(value);
	}

}