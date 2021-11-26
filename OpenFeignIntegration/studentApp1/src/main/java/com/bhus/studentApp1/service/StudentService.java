package com.bhus.studentApp1.service;

import com.bhus.studentApp1.document.Student;
import com.bhus.studentApp1.models.StudentRequest;
import org.springframework.web.bind.annotation.RequestBody;


public interface StudentService {
    Student saveStudent(@RequestBody  StudentRequest studentRequest);

    Student updateStudent(String id, StudentRequest request);

    void deleteById(String id);
}
