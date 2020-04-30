
select * from product where type_id='сыр';
select * from product where name like 'Мороженное%';
select * from product where expired_date between '01/05/20' and '31/05/20';
select max(price) from product;
select count(*) from product where type_id = '...';
select * from product where type_id in('сыр','молоко');
