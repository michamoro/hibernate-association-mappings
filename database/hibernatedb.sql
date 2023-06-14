create database hibernatedb;
use hibernatedb;

create table book (
	id int auto_increment primary key,
	name varchar(255) not null
);

create table iuser (
	id int auto_increment primary key,
    name varchar(255) not null
);

create table iuser_book (
	id int auto_increment primary key,
    iuser_id int,
    book_id int,
    foreign key (iuser_id) references iuser(id),
    foreign key (book_id) references book(id)
);