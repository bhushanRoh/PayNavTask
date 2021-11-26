package com.bhus.studentApp2.service;

import com.bhus.studentApp2.document.Student;
import com.bhus.studentApp2.models.StudentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "feignStudentService", url = "http://localhost:8082/v1/")
public interface StudentService {


    @GetMapping("/student/{id}")
    Student getstudent(@PathVariable("id") String id);

    @GetMapping("/student")
    Student saveStudent(StudentRequest studentRequest);

    /*@PutMapping("/student/{id}")
    Student updateStudent(String id, StudentRequest request);*/

    @DeleteMapping(path = "/student/{id}")
    void deleteById(@PathVariable("id") String id);
}
