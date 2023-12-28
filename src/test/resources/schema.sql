DROP TABLE BOOK IF EXISTS;
CREATE TABLE BOOK
(book_id INTEGER not null AUTO_INCREMENT,
 book_name VARCHAR(60) NOT NULL,
 author varchar(60) not null,
 price DECIMAL(15,2) NOT NULL,
 PRIMARY key (book_Id)
);

create table country
(country_name varchar(200) not null);

drop table state_table if exists;
create table state_table
(state_cd varchar(5) not null, 
state_description varchar(200) not null,
primary key (state_cd)
);
