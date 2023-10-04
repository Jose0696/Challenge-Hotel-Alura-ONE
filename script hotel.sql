create database hotel;
use hotel;

create table reserve(
	id int primary key auto_increment,
	nameI varchar(30) not null,
	lastname varchar(30) not null,
	age int not null,
	telephone bigint not null,
	country varchar(50) not null,
	admisionDate datetime not null,
	exitDate datetime not null,
	valueI varchar(10) not null,
	payWay varchar(20) not null
)engine=InnoDB;