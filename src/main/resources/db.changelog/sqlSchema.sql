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

--changeset akorzh:employee
create table if not exists employee
(
    id                  int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    first_name          varchar(64)                                          not null,
    last_name           varchar(64)                                          not null,
    patronymic          varchar(64)                                          not null,
    coefficient         varchar(64)                                          not null,
    children_count      bigint                                               not null,
    date_of_birth       date                                                 not null,
    date_of_employment  date                                                 not null,
    type                varchar(64)                                          not null,
    extra_vacation_days bigint                                               not null,
    gender              varchar(64)                                          not null
);
--rollback drop table employee;
--comment: Создана таблица employee

--changeset akorzh:day_off
create table if not exists day_off
(
    id          int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    date        date                                                 not null,
    employee_id int8                                                 not null
        constraint fk_foreign_key_ay_off_employee references employee
);
--rollback drop table day_off;
--comment: Создана таблица day_off

--changeset akorzh:--changeset akorzh:vacation
create table if not exists vacation
(
    id           int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    beginning    date                                                 not null,
    ending       date                                                 not null,
    compensation boolean                                              not null,
    status       varchar(64)                                          not null,
    employee_id  int8                                                 not null
        constraint fk_foreign_key_vacation_employee references employee
);
--rollback drop table vacation;
--comment: Создана таблица vacation

create table if not exists salary
(
    id               int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    wage             numeric(15, 2)                                       not null,
    amount           numeric(15, 2)                                       not null,
    recoupment       numeric(15, 2)                                       not null,
    ndfl             numeric(15, 2)                                       not null,
    retirement       numeric(15, 2)                                       not null,
    medical          numeric(15, 2)                                       not null,
    social           numeric(15, 2)                                       not null,
    calculation_date timestamp                                            not null,
    employee_id      int8                                                 not null
        constraint fk_foreign_key_salary_employee references employee
);
--rollback drop table salary;
--comment: Создана таблица salary

--changeset asoldatov:users
create table if not exists users
(
    id          int8 default nextval('hibernate_sequence'::regclass) not null primary key unique,
    login       varchar(64)                                          not null unique,
    password    varchar(64)                                          not null,
    user_role   varchar(64)                                          not null,
    employee_id int8                                                 not null
        constraint fk_foreign_key_user_employee references employee
);
--rollback drop table users;
--comment: Создана таблица users

--changeset asoldatov:employee1
alter table employee
    ADD COLUMN number_of_details         int8 NULL,
    ADD COLUMN hazard_ratio              int8 NULL,
    ADD COLUMN count_of_projects         int8 NULL,
    ADD COLUMN electrical_safety_gage    int8 NULL,
    ADD COLUMN fire_safety_rank          int8 NULL,
    ADD COLUMN information_security_rank int8 NULL;
--rollback alter table drop column number_of_details
--rollback alter table drop column hazard_ratio
--rollback alter table drop column count_of_projects
--rollback alter table drop column electrical_safety_gage
--rollback alter table drop column fire_safety_rank
--rollback alter table drop column information_security_rank
--comment: Создана таблица users
