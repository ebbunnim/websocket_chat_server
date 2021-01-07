create database web_chat default character set utf8 collate utf8_general_ci;
show databases;

use web_chat;
show tables;

drop table if exists member CASCADE;
create table member (
	id bigint primary key auto_increment,
    name varchar(255)
);
