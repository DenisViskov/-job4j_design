select p.name, c.name
from
(person as p join company as c on p.company_id=c.id)
where p.company_id != 5;

select c.name,count(c.id) as CountOfHumans
from
(person as p join company as c on p.company_id=c.id)
group by(c.name)
order by CountOfHumans desc
limit 1;

select *
from
(person as p join company as c on p.company_id=c.id);