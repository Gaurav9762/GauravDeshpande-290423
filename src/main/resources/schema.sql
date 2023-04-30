CREATE TABLE customer (
	id INT  primary key auto_increment,
	first_name varchar(100) not null,
	last_name varchar(100) not null
);


CREATE TABLE customer_mobileno (
	mobid INT primary key auto_increment not null,
	customerid int,
	mobile_number varchar not null,
	FOREIGN KEY (customerid) REFERENCES customer(id)
);


