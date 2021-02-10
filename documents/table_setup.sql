
-- table for users
create table users (
    user_id number(10) PRIMARY KEY,
    first_name varchar2(20),
    last_name varchar2(20),
    business_name varchar2(30),
    email varchar2(30),
    phone number(30),
    address_1 varchar2(30),
    address_2 varchar2(30),
    city varchar2(30),
    state varchar2(30),
    country varchar2(20),
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
    dimensions_in varchar2(50), -- "10in x 10in x 10in (HxWxL)"
    num_stocked number(100),
    num_ordered number(100),
    time_to_solve_mins number(10),
    type varchar2(30),
    retail_price number(10, 2),
    vendor_id number(10) -- foreign key to vendor table

);

-- transactions table
create table transactions (
    transaction_id number(10) PRIMARY KEY,
    date date,
    user_id number(10), -- foreign key to users table
    sale_price number(10, 2)
);


-- invoice table junction table / invoice (user end view) will use one t_id and this junction table
create table invoices (
    transaction_id number(10), -- FK to transaction
    item_id number(10), -- FK to inventory
    user_id number(10), -- FK to users
    item_quantity number(10)
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


