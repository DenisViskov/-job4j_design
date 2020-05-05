insert into body(name)
values
('sedan'),('Hatchback'),('Coupe'),('Van'),('jeep');

insert into engine(name)
values
('v8'),('v4'),('v2');

insert into transmission(name)
values
('auto'),('mechanical');

insert into cars(name,body_id,engine_id,transmission_id)
values
('Toyota 4runner',5,1,1),
('Lexus 570LX',5,1,1),
('Audi A8',1,1,1),
('Audi A6',1,2,1);