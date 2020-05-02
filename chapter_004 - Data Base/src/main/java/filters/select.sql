
select * from (product join type on product.type_id = type.ID) as total where total.type in('Сыр');

select * from product where name like 'Мороженное%';

select * from product where expired_date between '01/05/20' and '31/05/20';

select max(price) from product;

select count(*) from product where type_id = '...';

select * from (product join type on product.type_id = type.ID) as total where total.type in('Молочка','Сыр');

select total.name, total.type from (product join type on product.type_id = type.ID) as total;
