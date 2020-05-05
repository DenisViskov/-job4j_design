select * from cars;

select distinct body.name, engine.name, transmission.name from
(cars as c1 right outer join body on c1.body_id=body.id),
(cars as c2 right outer join engine on c2.engine_id=engine.id),
(cars as c3 right outer join transmission on c3.transmission_id=transmission.id)
where c1.name is null and c2.name is null and c3.name is null;