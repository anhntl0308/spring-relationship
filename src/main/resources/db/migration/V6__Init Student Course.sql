CREATE TABLE `student_course` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_student` int(11) unsigned NOT NULL references `student`(`id_student`),
    `id_course` int(11) unsigned NOT NULL references `course`(`id_course`),
     unique key (id_student, id_course)
);
insert into `student_course`(id, id_student, id_course)
values  (1,1,1),
        (2,4,1),
        (3,2,3),
        (4,3,4)
;
