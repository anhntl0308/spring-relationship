create table user
(
    id bigint auto_increment primary key,
    name varchar(255)
);

insert into user(name)
values ('Lan Anh'),
        ('Dat'),
        ('Duy');