--liquibase formatted sql

--changeset asoldatov:student1
create sequence if not exists hibernate_sequence
    increment 1
    minvalue 1
    maxvalue 9223372036854775807
    start 1
    cache 1;
--rollback drop sequence hibernate_sequence;
--comment: Добавлен hibernate_sequence

--changeset asoldatov:student2
create table if not exists student
(
    id          int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name        varchar(64)                                          not null,
    email       varchar(64)                                          not null unique,
    card_number varchar(64)                                          not null,
    group_name  varchar(64)                                          not null,
    subgroup    varchar(64)                                          not null
);
--rollback drop table student;
--comment: Создана таблица student

--changeset asoldatov:movie1
create table if not exists movie
(
    id     int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    name   varchar(64)                                          not null unique,
    author varchar(64)                                          not null
);
--rollback drop table movie;
--comment: Создана таблица movie
