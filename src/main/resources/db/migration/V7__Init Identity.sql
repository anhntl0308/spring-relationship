CREATE TABLE `identity`
(
    `id_identity` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code`        nvarchar(1000),
    `id_student`  int(11) unsigned NOT NULL UNIQUE KEY,
    foreign key (id_student) references student (id_student)
);
insert into identity(code, id_student)
values  ("112222245554",1),
        ("446454646545",2),
        ("854646465454",3),
        ("855554312313",4);
;