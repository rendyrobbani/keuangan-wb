drop table if exists data_user;

create or replace table data_user (
	id           varchar(18)  not null,
	pangkat      varchar(2)   not null,
	name         varchar(255) not null,
	title_prefix varchar(255) null,
	title_suffix varchar(255) null,
	password     varchar(255) null,
	gender       int(11)      null,
	number       int(11)      null,
	is_pns       bit(1)       null,
	is_p3k       bit(1)       null,
	is_locked    bit(1)       null,
	locked_at    datetime     null,
	locked_by    varchar(18)  null,
	created_at   datetime     null,
	created_by   varchar(18)  null,
	updated_at   datetime     null,
	updated_by   varchar(18)  null,
	is_deleted   bit(1)       null,
	deleted_at   datetime     null,
	deleted_by   varchar(18)  null,
	constraint ck_data_user_01 check (id regexp '^(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2]|21)([12])(00[1-9]|[0-9][1-9][0-9]|[1-9][0-9][0-9])$'),
	constraint ck_data_user_02 check (pangkat regexp '[1-4][A-D]|4E|0[1-9]|1[0-7]'),
	constraint ck_data_user_03 check (gender in (1,2)),
	constraint ck_data_user_04 check (number between 1 and 999),
	constraint fk_data_user_01 foreign key (locked_by) references data_user (id),
	constraint fk_data_user_02 foreign key (created_by) references data_user (id),
	constraint fk_data_user_03 foreign key (updated_by) references data_user (id),
	constraint fk_data_user_04 foreign key (deleted_by) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;