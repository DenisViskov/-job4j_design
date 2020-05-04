select * from cars;

select b.name, e.name, t.name from
(cars as c1 right outer join body as b on c1.body_id=b.id),
(cars as c2 right outer join engine as e on c2.engine_id=e.id),
(cars as c3 right outer join transmission as t on c3.transmission_id=t.id)
where c1.name is null or c2.name is null or c3.name is null;