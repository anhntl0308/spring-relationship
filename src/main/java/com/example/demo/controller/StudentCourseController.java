package com.example.demo.controller;

import com.example.demo.domain.dto.CourseDto;
import com.example.demo.domain.dto.StudentCourseDto;
import com.example.demo.domain.dto.StudentDto;
import com.example.demo.domain.entity.Course;
import com.example.demo.domain.entity.Identity;
import com.example.demo.domain.entity.Student;
import com.example.demo.domain.entity.StudentCourse;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentCourseController {

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
//C1: avoid stackoverflow, use anotation @BackReference
        @GetMapping()
    public ResponseEntity<List<StudentCourse>> getAllStudentCourse(@RequestParam(required = false) String search) {
            List<StudentCourse> studentCourseList = studentCourseRepository.findStudentCourseByCourseName(search);
            return ResponseEntity.ok(studentCourseList);
        }
        //C2: avoid stackoverflow, use dto
//    @GetMapping()
//    public ResponseEntity<List<StudentCourseDto>> getAllStudentCourse(@RequestParam(required = false) String search) {
//        List<StudentCourse> studentCourseList = studentCourseRepository.findStudentCourseByCourseName(search);
//        List<StudentCourseDto> dtoList = new LinkedList<>();
//        studentCourseList.forEach(studentCourse -> {
//            StudentCourseDto studentCourseDto = new StudentCourseDto();
//            CourseDto courseDto = new CourseDto();
//            courseDto.setName(studentCourse.getCourse().getName());
//            studentCourseDto.setCourse(courseDto);
//            StudentDto studentDto = new StudentDto();
//            studentDto.setName(studentCourse.getStudent().getName());
//            studentDto.setCode(studentCourse.getStudent().getIdentity().getCode());
//            studentCourseDto.setStudent(studentDto);
//            dtoList.add(studentCourseDto);
//        });
//        return ResponseEntity.ok(dtoList);
//    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        //set name student
        student.setName(studentDto.getName());
        //set identity student
        Identity identity = new Identity();
        identity.setCode(studentDto.getCode());
        identity.setStudent(student);
        student.setIdentity(identity);
        //save student
        studentRepository.save(student);
        return ResponseEntity.ok("success!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("does not exist student"));
        student.setName(studentDto.getName());
        Identity identity = new Identity();
        identity.setCode(studentDto.getCode());
        identity.setId(student.getIdentity().getId());
        identity.setStudent(student);
        student.setIdentity(identity);
        studentRepository.save(student);
        return ResponseEntity.ok("success!");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("does not exist student"));
        studentRepository.delete(student);
        return ResponseEntity.ok("success!");
    }



//    @PostMapping
//    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
//        Student student = new Student();
//        student.setName(studentDto.getName());
//        Identity identity = new Identity();
//        identity.setCode("89372132");
//        identity.setStudent(student);
//        student.setIdentity(identity);
//        StudentCourse studentCourse = new StudentCourse();
//        studentCourse.setStudent(student);
//        studentCourse.setCourse(new Course(1L, null, null));
//        student.setStudentCourseList(Arrays.asList(studentCourse));
//
//        studentRepository.save(student);
//        return ResponseEntity.ok("success!");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateStudent(@PathVariable(name = "id") Long id, @RequestBody StudentDto studentDto) {
//        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("does not exist student"));
//        student.setName(studentDto.getName());
//        Identity identity = new Identity();
//        identity.setCode(studentDto.getCode());
//        student.setIdentity(identity);
//
////        StudentCourse studentCourse = new StudentCourse();
////        studentCourse.setStudent(student);
////        List<StudentCourse> studentCourseList = studentCourseRepository.findStudentCourseByStudentId(id);
////        List<StudentCourse> list = new LinkedList<>();
////        studentCourseList.forEach(sc ->{
////            sc.setStudent(student);
////            sc.setCourse(new Course(2L, null, null));
////            list.add(sc);
////                } );
////        student.setStudentCourseList(studentCourseList);
//        studentRepository.save(student);
//        return ResponseEntity.ok("success!");
//    }


}
