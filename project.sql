--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;


SET default_tablespace = '';

SET default_with_oids = false;


---
--- drop tables
---


DROP TABLE IF EXISTS clients;

create table project IF NOT EXIST(
    project_id serial primary key
    project_name varchar(200) not null
    description varchar(400) not null
);

insert into project(project_name, description) values ('client micro-service', 'tcms clients service');
insert into project(project_name, description) values ('logging micro-service', 'tcms logging pub/sub service');
insert into project(project_name, description) values ('email micro-service', 'tcms email pub/sub service');
insert into project(project_name, description) values ('project micro-service', 'tcms project service');
