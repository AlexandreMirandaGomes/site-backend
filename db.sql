create table message (
id int8 not null primary key,
text varchar(255) not null,
date date not null
);

CREATE SEQUENCE message_id_seq;

create table user_data (
id int8 not null primary key,
name varchar(255) not null,
password varchar(255) not null,
created date not null
);

CREATE SEQUENCE user_id_seq;

create table tokens (
id int8 not null primary key,
token varchar not null,
created date not null,
id_user int8 not null
);

CREATE SEQUENCE tokens_id_seq;

