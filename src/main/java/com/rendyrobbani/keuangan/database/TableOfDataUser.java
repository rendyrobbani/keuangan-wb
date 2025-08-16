package com.rendyrobbani.keuangan.database;

import com.rendyrobbani.database.mariadb.anotation.*;
import com.rendyrobbani.keuangan.domain.model.vo.Nip;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(fluent = true)
@Table(name = TableOfDataUser.NAME)
@Checks(value = {
		@Check(expression = "id regexp '" + Nip.REGEX + "'"),
		@Check(expression = "pangkat regexp '" + Pangkat.REGEX + "'"),
		@Check(expression = "gender in (1,2)"),
		@Check(expression = "number between 1 and 999"),
})
@ForeignKeys(value = {
		@ForeignKey(columns = {"locked_by"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
		@ForeignKey(columns = {"created_by"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
		@ForeignKey(columns = {"updated_by"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
		@ForeignKey(columns = {"deleted_by"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
})
public class TableOfDataUser {

	public static final String NAME = "data_user";

	@Column(name = "id", length = 18, primaryKey = true)
	private String id;

	@Column(name = "pangkat", length = 2, nullable = false)
	private String pangkat;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "title_prefix")
	private String titlePrefix;

	@Column(name = "title_suffix")
	private String titleSuffix;

	@Column(name = "password")
	private String password;

	@Column(name = "gender")
	private Integer gender;

	@Column(name = "number")
	private Integer number;

	@Column(name = "is_pns")
	private boolean isPNS;

	@Column(name = "is_p3k")
	private boolean isP3K;

	@Column(name = "is_locked")
	private boolean isLocked;

	@Column(name = "locked_at")
	private LocalDateTime lockedAt;

	@Column(name = "locked_by", length = 18)
	private String lockedBy;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "created_by", length = 18)
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "updated_by", length = 18)
	private String updatedBy;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	@Column(name = "deleted_by", length = 18)
	private String deletedBy;

}