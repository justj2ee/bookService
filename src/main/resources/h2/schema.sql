DROP TABLE BOOK IF EXISTS;
CREATE TABLE BOOK
(book_id INTEGER not null AUTO_INCREMENT,
 book_name VARCHAR(60) NOT NULL,
 author varchar(60) not null,
 price DECIMAL(15,2) NOT NULL,
 PRIMARY key (book_Id)
);
