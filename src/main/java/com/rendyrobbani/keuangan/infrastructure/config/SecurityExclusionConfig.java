package com.rendyrobbani.keuangan.infrastructure.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class SecurityExclusionConfig {

}