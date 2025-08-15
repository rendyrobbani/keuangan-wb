drop table if exists logs_user;

create or replace table logs_user (
	id            bigint(20)   not null auto_increment,
	pangkat       char(2)      not null,
	name          varchar(255) not null,
	title_prefix  varchar(255) null,
	title_suffix  varchar(255) null,
	password      varchar(255) not null,
	date_of_birth date         not null,
	date_of_start date         null,
	gender        tinyint(4)   not null,
	number        smallint(6)  not null,
	is_pns        bit(1)       not null,
	is_p3k        bit(1)       not null,
	is_locked     bit(1)       not null,
	is_deleted    bit(1)       not null,
	logged_at     datetime     null,
	logged_by     char(18)     null,
	subject_id    char(18)     null,
	constraint fk_logs_user_01 foreign key (logged_by) references data_user (id),
	constraint fk_logs_user_02 foreign key (subject_id) references data_user (id),
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;