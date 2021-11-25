package com.bhus.student.controller;

import com.bhus.student.dao.StudentDao;
import com.bhus.student.document.StudentDocument;
import com.bhus.student.model.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class StudentController {


    @Autowired
    StudentDao studentDao;


    @PostMapping("/student2")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/student2/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable String studentId, @RequestBody StudentRequest request){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/student2/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getStudentById(@PathVariable final String id){
        Optional<StudentDocument> studentDocuments=studentDao.findById(id);
        return new ResponseEntity<>(studentDocuments.get(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/student2/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudentById(@PathVariable final String studentId){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT);
    }
}
