
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
    access_id integer,
    foreign key(access_id) references roles_accesses(id)
);

create table users(
    id serial primary key,
    login varchar(20),
    whole_name varchar(50),
    role_id integer,
    registration_date date,
    foreign key(role_id) references user_role(id)
);

create table comments(
    id serial primary key,
    message text,
    user_id integer,
    created_time timestamp,
    attachment_id integer,
    foreign key (user_id) references users(id),
    foreign key (attachment_id) references attachments(id)
);

create table tasks(
    id serial primary key,
    user_id integer,
    comment_id integer,
    state_id integer,
    create_date timestamp,
    category_id integer,
    foreign key (user_id) references users(id),
    foreign key (comment_id) references comments(id),
    foreign key (state_id) references states(id),
    foreign key (category_id) references categories(id)
);