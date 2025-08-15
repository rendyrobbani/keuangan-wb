package com.rendyrobbani.keuangan.common.schema.constraint.check;

import com.rendyrobbani.keuangan.common.schema.constraint.Constraint;

public interface CheckConstraint extends Constraint {

	String logic();

	@Override
	default String value() {
		return "check (" + this.logic() + ")";
	}

}