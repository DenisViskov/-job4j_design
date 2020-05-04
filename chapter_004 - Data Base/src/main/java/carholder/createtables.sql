create table body(
     id serial primary key,
     name varchar(20)
);

create table engine(
     id serial primary key,
     name varchar(10)
);

create table transmission(
     id serial primary key,
     name varchar(10)
);

create table cars(
     id serial primary key,
     name varchar(20),
     body_id int references body(id),
     engine_id int references engine(id),
     transmission_id int references transmission(id)
);