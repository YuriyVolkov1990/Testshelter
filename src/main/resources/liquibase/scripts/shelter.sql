create table cat_shelter (
    id bigserial primary key,
    info text not null,
    guardData text not null,
    recommendation text not null,
    contact text not null
);

create table dog_shelter (
    id bigserial primary key,
    info text not null,
    guardData text not null,
    recommendation text not null,
    contact text not null
);

create table cat (
    id bigserial primary key,
    name text not null,
    age text not null,
    color text not null
);

create table dog (
    id bigserial primary key,
    name text not null,
    age text not null,
    color text not null
);

create table volunteer (
    id bigserial primary key,
    name text not null,
    surname text not null,
    phone text not null,
    email text not null
);