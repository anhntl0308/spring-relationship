create table user_permission
    (
        id bigint auto_increment primary key,
        user_id bigint,
        permission varchar(1),
        foreign key (user_id) references user(id)
)
;
insert into user_permission(user_id, permission)
    values  (1,"r"),
            (1,"e"),
            (2,"r"),
            (3,"w");