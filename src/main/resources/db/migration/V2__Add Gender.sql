alter table user
add column gender varchar(1);

update user
set user.gender = 'm'
where user.gender is null;