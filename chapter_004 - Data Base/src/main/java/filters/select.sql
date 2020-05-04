
select * from (product as p join type as t on p.type_id = t.ID) where t.name in('Сыр');

select * from product where name like 'Мороженное%';

select * from product where expired_date between '01/05/20' and '31/05/20';

select max(price) from product;

select count(*) from product where type_id = '...';

select * from (product as p join type as t on p.type_id = t.ID) where t.name in('Молочка','Сыр');

select tp.name, count(tp.name) as typecount from (product as pr join type as tp on pr.type_id=tp.id) group by tp.name having count(*)<10;

select total.name, total.type from (product join type on product.type_id = type.ID) as total;