-- liquibase formatted sql

--chageset volkov:1
create table shelter(
    id bigserial primary key,
    chat_id int8 not null,
    message text not null,
    exec_date timestamp not null
)