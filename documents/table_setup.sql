
-- table for users
create table users (
    user_id number(10) PRIMARY KEY,
    first_name varchar2(20),
    last_name varchar2(20),
    email varchar2(30),
    phone number(15),
    address_1 varchar2(30),
    address_2 varchar2(10),
    street varchar2(30),
    city varchar2(30),
    zip number(15)
);

