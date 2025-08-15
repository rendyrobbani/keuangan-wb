package com.rendyrobbani.keuangan.domain.port.outgoing.repository;

import com.rendyrobbani.keuangan.domain.model.entity.Base;

import java.util.List;

public interface SelectRepository<DOMAIN extends Base<ID>, ID> {

	List<DOMAIN> selectAll();

	DOMAIN selectById(ID id);

}