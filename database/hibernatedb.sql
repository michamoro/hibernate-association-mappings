create database hibernatedb;
use hibernatedb;

create table post (
    id int auto_increment primary key,
    title varchar(255) not null
);

create table post_comment (
    id int auto_increment primary key,
    review varchar(255) not null,
    post_id int,
    foreign key (post_id) references post(id)
);