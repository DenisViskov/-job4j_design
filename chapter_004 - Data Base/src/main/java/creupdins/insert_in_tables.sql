insert into attachments(format, size, url) values ('txt',25.5,'google.com');

insert into categories(type) values ('Critical');
insert into categories(type) values ('High');
insert into categories(type) values ('Middle');
insert into categories(type) values ('Low');

insert into states(type) values ('active');
insert into states(type) values ('closed');
insert into states(type) values ('hold');

insert into roles_accesses(type) values ('whole_acces');
insert into roles_accesses(type) values ('edit|add');
insert into roles_accesses(type) values ('delete|add');
insert into roles_accesses(type) values ('read_only');

insert into user_role(type,access_id) values ('admin',1);
insert into user_role(type,access_id) values ('user',2);
insert into user_role(type,access_id) values ('guest',4);

insert into users(login,whole_name,role_id,registration_date) values ('vasya','Ivanov Vasilyi Petrovich',2,current_date);

insert into comments(message,user_id,created_time,attachment_id) values ('Hi all',1,'2004-10-19 10:23:54',1);

insert into tasks(user_id,comment_id,state_id,create_date,category_id) values (1,1,2,current_date,2);