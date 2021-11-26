package com.bhus.studentApp1.controller;

import com.bhus.studentApp1.dao.StudentDao;
import com.bhus.studentApp1.document.Student;
import com.bhus.studentApp1.models.StudentRequest;
import com.bhus.studentApp1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/v1")
@RestController
public class StudentController {
   @Autowired
    StudentService studentService;

   @Autowired
    StudentDao studentDao;


    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.saveStudent(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getStudentById(@PathVariable final String id){
        Optional<Student> studentDocuments=studentDao.findById(id);
        return new ResponseEntity<>(studentDocuments.get(),HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody StudentRequest request){
        return new ResponseEntity<>(studentService.updateStudent(id,request),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudentById(@PathVariable final String id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT);
    }


}
