
create table users(
    id serial primary key,
    login varchar(20),
    whole_name varchar(50),
    role integer,
    task integer,
    registration_date date,
    foreign key (role) references roles(id),
    foreign key (task) references tasks(id)
);

create table roles(
    id serial primary key,
    type varchar(20),
    access integer,
    foreign key (access) references accesses(id)
);

create table accesses(
    id serial primary key,
    type varchar(20)
);

create table tasks(
    id serial primary key,
    description integer,
    state integer,
    create_date timestamp,
    category integer,
    foreign key (description) references comments(id),
    foreign key (state) references states(id),
    foreign key (category) references categories(id)
);

create table categories(
    id serial primary key,
    type varchar(15)
);

create table states(
    id serial primary key,
    type varchar(15)
);

create table extensions(
    id serial primary key,
    format varchar(3),
    size numeric(4,2),
    URL text
);

create table comments(
    id serial primary key,
    message text,
    author integer,
    created_time timestamp,
    extension integer,
    foreign key (author) references users(id),
    foreign key (extension) references extensions(id)
);