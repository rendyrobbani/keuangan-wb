drop table if exists logs_user;

create or replace table logs_user (
	id           bigint(20)   not null auto_increment,
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
	is_deleted   bit(1)       null,
	logged_at    datetime     null,
	logged_by    varchar(18)  null,
	subject_id   varchar(18)  not null,
	constraint ck_logs_user_01 check (pangkat regexp '[1-4][A-D]|4E|0[1-9]|1[0-7]'),
	constraint ck_logs_user_02 check (gender in (1,2)),
	constraint ck_logs_user_03 check (number between 1 and 999),
	constraint fk_logs_user_01 foreign key (logged_by) references data_user (id),
	constraint fk_logs_user_02 foreign key (subject_id) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;