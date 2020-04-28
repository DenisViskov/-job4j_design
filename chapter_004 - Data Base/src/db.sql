
create table users(
    id serial primary key,
    login varchar(20),
    whole_name varchar(50),
    role integer references roles(id),
    task integer references tasks(id),
    registration_date date
);

create table roles(
    id serial primary key,
    type varchar(20),
    accesses integer references accesses(id)
)

create table accesses(
    id serial primary key,
    type varchar(20)
)

create table tasks(
    id serial primary key,
    description integer references comments(id),
    state integer references state(id),
    create_date timestamp,
    category integer references categories(id)
)

create table categories(
    id serial primary key,
    type varchar(15)
)

create table state(
    id serial primary key,
    type varchar(15)
)

create table extensions(
    id serial primary key,
    format varchar(3),
    size numeric(4,2),
    URL text
)

create table comments(
    id serial primary key,
    message text,
    author integer references users(id),
    created_time timestamp,
    extensions integer references extensions(id)
)