package com.rendyrobbani.keuangan.infrastructure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.model.vo.Role;
import com.rendyrobbani.keuangan.infrastructure.serialization.json.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class ObjectMapperConfig {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(
				new SimpleModule()
						.addDeserializer(Gender.class, new GenderDeserializer())
						.addDeserializer(LocalDate.class, new LocalDateDeserializer())
						.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer())
						.addDeserializer(Nip.class, new NipDeserializer())
						.addDeserializer(Pangkat.class, new PangkatDeserializer())
						.addDeserializer(Role.class, new RoleDeserializer())
						.addSerializer(Gender.class, new GenderSerializer())
						.addSerializer(LocalDate.class, new LocalDateSerializer())
						.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer())
		);
	}

}