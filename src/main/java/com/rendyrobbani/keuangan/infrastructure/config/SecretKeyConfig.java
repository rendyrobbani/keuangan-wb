package com.rendyrobbani.keuangan.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecretKeyConfig {

	@Value("${com.rendyrobbani.latte.mode}")
	private String mode;

	@Bean
	public SecretKey secretKey() throws Exception {
		if (mode.equalsIgnoreCase("dev")) {
			try (var resource = getClass().getResourceAsStream("/dev/secretKey")) {
				if (resource == null) throw new NullPointerException();
				return new SecretKeySpec(resource.readAllBytes(), "HmacSHA256");
			}
		} else {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			keyGenerator.init(256);
			return keyGenerator.generateKey();
		}
	}

}