CREATE DATABASE 'db';
USE db;

create table data (
	id  int(3) NOT NULL AUTO_INCREMENT,
	name varchar(120) NOT NULL,
	adress varchar(220) NOT NULL,
	phone varchar(120),
	salary varchar(220) NOT NULL,
	net varchar(220) NOT NULL,
	total varchar(220) NOT NULL,
	PRIMARY KEY (id)
);

