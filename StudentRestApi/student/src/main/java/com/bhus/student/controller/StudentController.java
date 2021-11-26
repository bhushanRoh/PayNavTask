package com.bhus.student.controller;

import com.bhus.student.dao.StudentDao;
import com.bhus.student.document.StudentDocument;
import com.bhus.student.model.StudentRequest;
import com.bhus.student.service.StudentService;
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

    @PutMapping("/student/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable String studentId, @RequestBody StudentRequest request){
        return new ResponseEntity<>(studentService.updateStudent(studentId,request),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getStudentById(@PathVariable final String id){
        Optional<StudentDocument> studentDocuments=studentDao.findById(id);
        return new ResponseEntity<>(studentDocuments.get(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/student/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudentById(@PathVariable final String studentId){
        studentService.deleteById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT);
    }
}
