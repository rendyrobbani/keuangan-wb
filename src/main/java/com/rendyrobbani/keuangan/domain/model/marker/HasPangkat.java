package com.rendyrobbani.keuangan.domain.model.marker;

import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;

public interface HasPangkat {

	Pangkat pangkat();

	default String pangkatValue() {
		if (pangkat() == null) return null;
		return pangkat().value();
	}

	default String pangkatLabel() {
		if (pangkat() == null) return null;
		return pangkat().label();
	}

	default String pangkatTitle() {
		if (pangkat() == null) return null;
		return pangkat().title();
	}

}