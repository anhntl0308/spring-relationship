package com.example.demo.repository;

import com.example.demo.domain.entity.Course;
import com.example.demo.domain.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    List<StudentCourse> findStudentCourseByCourseName(String course);
    List<StudentCourse> findStudentCourseByStudentId(Long id);

}
