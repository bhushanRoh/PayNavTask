package com.bhus.student.service;

import com.bhus.student.model.StudentRequest;
import com.bhus.student.model.StudentResponse;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(String studentId, StudentRequest request);

    StudentResponse getStudentById(String studentId);

    void deleteById(String studentId);
}
