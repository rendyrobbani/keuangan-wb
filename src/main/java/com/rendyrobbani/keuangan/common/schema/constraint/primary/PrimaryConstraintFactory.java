package com.rendyrobbani.keuangan.common.schema.constraint.primary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PrimaryConstraintFactory {

	public static PrimaryConstraint create(List<String> columnNames) {
		return new PrimaryConstraintImpl(columnNames);
	}

}