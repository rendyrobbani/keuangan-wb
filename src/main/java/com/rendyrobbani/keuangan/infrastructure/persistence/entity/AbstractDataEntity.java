package com.rendyrobbani.keuangan.infrastructure.persistence.entity;

import com.rendyrobbani.keuangan.domain.model.entity.Data;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.infrastructure.persistence.converter.NipConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class AbstractDataEntity<DOMAIN extends Data<ID>, ID> extends AbstractBaseEntity<DOMAIN, ID> implements Data<ID> {

	@Column(name = "created_at")
	protected LocalDateTime createdAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "created_by")
	protected Nip createdBy;

	@Column(name = "updated_at")
	protected LocalDateTime updatedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "updated_by")
	protected Nip updatedBy;

	@Column(name = "is_deleted")
	protected boolean isDeleted;

	@Column(name = "deleted_at")
	protected LocalDateTime deletedAt;

	@Convert(converter = NipConverter.class)
	@Column(name = "deleted_by")
	protected Nip deletedBy;

	public abstract void sync(DOMAIN domain);

	public void create(DOMAIN domain, LocalDateTime createdAt, Nip createdBy) {
		this.sync(domain);
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.isDeleted = false;
	}

	public void update(DOMAIN domain, LocalDateTime updatedAt, Nip updatedBy) {
		this.sync(domain);
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public void delete(LocalDateTime deletedAt, Nip deletedBy) {
		this.isDeleted = true;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
	}

	public void revive(LocalDateTime updatedAt, Nip updatedBy) {
		this.isDeleted = false;
		this.deletedAt = null;
		this.deletedBy = null;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

}