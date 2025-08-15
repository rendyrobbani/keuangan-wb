package com.rendyrobbani.keuangan.infrastructure.persistence.entity.user;

import com.rendyrobbani.keuangan.schema.user.LogsUserTable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@Entity
@Table(name = LogsUserTable.NAME)
public class LogsUserEntity extends AbstractLogsUserEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DataUserEntity subject;

}