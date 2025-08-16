package com.rendyrobbani.keuangan.database;

import com.rendyrobbani.database.mariadb.anotation.*;
import com.rendyrobbani.keuangan.domain.model.vo.Pangkat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(fluent = true)
@Table(name = TableOfLogsUser.NAME)
@Checks(value = {
		@Check(expression = "pangkat regexp '" + Pangkat.REGEX + "'"),
		@Check(expression = "gender in (1,2)"),
		@Check(expression = "number between 1 and 999"),
})
@ForeignKeys(value = {
		@ForeignKey(columns = {"logged_by"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
		@ForeignKey(columns = {"subject_id"}, referenceTable = TableOfDataUser.class, referenceColumns = {"id"}),
})
public final class TableOfLogsUser {

	public static final String NAME = "logs_user";

	@Column(name = "id", autoIncrement = true)
	private Long id;

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

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "logged_at")
	private LocalDateTime loggedAt;

	@Column(name = "logged_by", length = 18)
	private String loggedBy;

	@Column(name = "subject_id", length = 18, nullable = false)
	private String subjectId;

}