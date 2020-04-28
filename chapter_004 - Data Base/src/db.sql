
create table categories(
    id serial primary key,
    type varchar(15)
);

create table states(
    id serial primary key,
    type varchar(15)
);

create table attachments(
    id serial primary key,
    format varchar(3),
    size numeric(4,2),
    URL text
);

create table roles_accesses(
    id serial primary key,
    type varchar(20)
);

create table user_role(
    id serial primary key,
    type varchar(20),
    access_id integer
);

create table users(
    id serial primary key,
    login varchar(20),
    whole_name varchar(50),
    role_id integer,
    registration_date date
);

create table comments(
    id serial primary key,
    message text,
    user_id integer,
    created_time timestamp,
    attachment_id integer,
);

create table tasks(
    id serial primary key,
    user_id integer,
    comment_id integer,
    state_id integer,
    create_date timestamp,
    category_id integer
);