CREATE DATABASE IF NOT EXISTS virtusaNotifier;
use virtusaNotifier;

CREATE TABLE users (
ID int not null auto_increment,
userName varchar(255) default null,
email varchar(255) default null,
passWord varchar(255) default null,
mobNo varchar(255) default null,
primary key (ID));

CREATE TABLE notebooks(
NID int not null auto_increment,
UID int not null,
bookName varchar(255),
totalNotes int,
primary key (NID));

CREATE TABLE notes(
noteId int not null auto_increment,
NID int, UID int,
noteName varchar(255),
Status varchar(255),
Description varchar(255),
startDate  varchar(255),
endDate varchar(255),
reminderDate varchar(255),
tag varchar(255),
primary key (noteId));
