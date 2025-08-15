package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.domain.model.vo.Gender;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import com.rendyrobbani.keuangan.domain.model.entity.user.DataUser;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.GenderConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.PangkatConverter;
import com.rendyrobbani.keuangan.infrastructure.persistence.entity.AbstractLockEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Accessors(chain = false, fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractDataUserEntity extends AbstractLockEntity<DataUser, String> implements DataUser {

	@Id
	@Column(name = "id")
	protected String id;

	@Convert(converter = NipConverter.class)
	@Column(name = "id", insertable = false, updatable = false)
	protected Nip nip;

	@Convert(converter = PangkatConverter.class)
	@Column(name = "pangkat")
	protected Pangkat pangkat;

	@Column(name = "name")
	protected String name;

	@Column(name = "title_prefix")
	protected String titlePrefix;

	@Column(name = "title_suffix")
	protected String titleSuffix;

	@Column(name = "password")
	protected String password;

	@Column(name = "date_of_birth")
	protected LocalDate dateOfBirth;

	@Column(name = "date_of_start")
	protected LocalDate dateOfStart;

	@Convert(converter = GenderConverter.class)
	@Column(name = "gender")
	protected Gender gender;

	@Column(name = "number")
	protected Integer number;

	@Column(name = "is_pns")
	protected boolean isPNS;

	@Column(name = "is_p3k")
	protected boolean isP3K;

	@Override
	public DataUser toDomain() {
		return this;
	}

	@Override
	public void sync(DataUser domain) {
		this.id = domain.id();
		this.nip = domain.nip();
		this.pangkat = domain.pangkat();
		this.name = domain.name();
		this.titlePrefix = domain.titlePrefix();
		this.titleSuffix = domain.titleSuffix();
		this.password = domain.password();
		this.dateOfBirth = domain.dateOfBirth();
		this.dateOfStart = domain.dateOfStart();
		this.gender = domain.gender();
		this.number = domain.number();
		this.isPNS = domain.isPNS();
		this.isP3K = domain.isP3K();
	}

}