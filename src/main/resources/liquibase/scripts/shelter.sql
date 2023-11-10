-- liquibase formatted sql
--
-- changeset name:1
create table user (
    id bigserial primary key,
    game text not null,
    phoneNumber bigint not null
);

create table cat_shelter (
    id bigserial primary key,
    info text not null,
    guard_data text not null,
    recommendation text not null,
    contact text not null
);

create table dog_shelter (
    id bigserial primary key,
    info text not null,
    guard_data text not null,
    recommendation text not null,
    contact text not null
);

create table cat (
    id bigserial primary key,
    game text not null,
    age int not null,
    color text not null
);

create table dog (
    id bigserial primary key,
    game text not null,
    age int not null,
    color text not null
);

create table volunteer (
    id bigserial primary key,
    game text not null,
    surname text not null,
    phone text not null,
    email text not null
);