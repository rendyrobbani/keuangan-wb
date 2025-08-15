package com.rendyrobbani.keuangan.domain.auth;

import com.rendyrobbani.keuangan.domain.model.vo.Role;

import java.util.List;

public interface WebAuthorizationService {

	void hasInRole(List<Role> roles);

	default void hasInRole(Role... roles) {
		this.hasInRole(List.of(roles));
	}

	default void hasInRole() {
		this.hasInRole(List.of());
	}

}