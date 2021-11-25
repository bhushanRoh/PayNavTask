package com.bhus.cloud.studenteureka.service;

import com.bhus.cloud.studenteureka.model.StudentRequest;
import com.bhus.cloud.studenteureka.model.StudentResponse;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(String studentId, StudentRequest request);

    StudentResponse getStudentById(String studentId);

    void deleteById(String studentId);
}
