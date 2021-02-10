
-- table for users
create table users (
    user_id serial PRIMARY KEY,
    first_name varchar(20),
    last_name varchar(20),
    business_name varchar(30),
    email varchar(30),
    phone numeric(30),
    address_1 varchar(30),
    address_2 varchar(30),
    city varchar(30),
    state varchar(30),
    country varchar(20),
    zip numeric(15)
);


-- vendor table
create table vendors (
    vendor_id serial PRIMARY KEY,
    name varchar(20),
    contact varchar(20),
    email varchar(30),
    phone numeric(15),
    website varchar(30),
    address_1 varchar(30),
    address_2 varchar(10),
    street varchar(30),
    city varchar(30),
    zip numeric(15),
    notes varchar(1000)
);


-- table for inventory items
create table inventory (
    item_id serial PRIMARY KEY,
    name varchar(20),
    description varchar(500),
    weight_oz varchar(10),
    dimensions_in varchar(50), -- "10in x 10in x 10in (HxWxL)"
    num_stocked numeric(100),
    num_ordered numeric(100),
    time_to_solve_mins numeric(10),
    type varchar(30),
    retail_price numeric(10, 2),
    vendor_id integer -- foreign key to vendor table
);


-- transactions table
create table transactions (
    transaction_id serial PRIMARY KEY,
    date date,
    user_id integer, -- foreign key to users table
    sale_price numeric(10, 2)
);


-- invoice table junction table / invoice (user end view) will use one t_id and this junction table
create table invoices (
    transaction_id integer, -- FK to transaction
    item_id integer, -- FK to inventory
    user_id integer, -- FK to users
    item_quantity integer
);







-- reviews table
create table reviews (
    review_id serial PRIMARY KEY,
    item_id integer, -- foreign key to inventory table
    user_rating integer,
    user_difficulty_rating integer,
    user_review varchar(1000),
    company_rating integer,
    company_difficulty_rating integer,
    company_review varchar(1000)
);
