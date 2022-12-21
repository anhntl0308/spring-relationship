CREATE TABLE `course` (
    `id_course` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name_course` nvarchar(1000)
);
insert into `course`(id_course, name_course)
values  (1,"math"),
        (2,"english"),
        (3,"history"),
        (4,"literature")
;