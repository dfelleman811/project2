
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

-- vendor table
create table vendors (
    vendor_id number(10) PRIMARY KEY,
    name varchar2(20),
    contact varchar2(20),
    email varchar2(30),
    phone number(15),
    website varchar2(30),
    address_1 varchar2(30),
    address_2 varchar2(10),
    street varchar2(30),
    city varchar2(30),
    zip number(15),
    notes varchar2(1000)
);

-- table for inventory items
create table inventory (
    item_id number(10) PRIMARY KEY,
    name varchar2(20),
    description varchar2(500),
    weight_oz varchar2(10),
    length_cm number(10),
    width_cm number(10),
    height_cm number(10),
    num_stocked number(100),
    num_ordered number(100),
    time_to_solve_mins number(10),
    type varchar2(30),
    vendor_id number(10) -- foreign key to vendor table

);

-- transactions table
create table transcactions (
    transaction_id number(10) PRIMARY KEY,
    date date,
    user_id number(10), -- foreign key to users table
    item_id number(10),
    sale_price number(10)
);

-- reviews table
create table reviews (
    review_id number(10) PRIMARY KEY,
    item_id number(10), -- foreign key to inventory table
    user_rating number(10),
    user_difficulty_rating number(10),
    user_review varchar2(1000),
    company_rating number(10),
    company_diff_rating number(10),
    company_review varchar2(1000)
);


