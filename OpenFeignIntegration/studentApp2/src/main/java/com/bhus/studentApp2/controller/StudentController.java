package com.bhus.studentApp2.controller;

import com.bhus.studentApp2.document.Student;
import com.bhus.studentApp2.models.StudentRequest;
import com.bhus.studentApp2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("student2/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return studentService.getstudent(id);
    }

    @PostMapping("/student2")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return studentService.saveStudent(studentRequest);
    }

   /* @PutMapping("/student2/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentRequest request){
        return studentService.updateStudent(id,request);
    }*/

    @DeleteMapping(path = "/student2/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student deleteStudentById(@PathVariable final String id){
        studentService.deleteById(id);
        return null;
    }

}
