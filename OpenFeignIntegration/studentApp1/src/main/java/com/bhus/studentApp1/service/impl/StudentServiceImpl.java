package com.bhus.studentApp1.service.impl;

import com.bhus.studentApp1.dao.StudentDao;
import com.bhus.studentApp1.document.Student;
import com.bhus.studentApp1.exception.ResourceNotFoundException;
import com.bhus.studentApp1.models.StudentRequest;
import com.bhus.studentApp1.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentDao studentDocumentDao;


    @Override
    public Student saveStudent(StudentRequest studentRequest) {
        Student student= objectMapper.convertValue(studentRequest,Student.class);
        studentDocumentDao.save(student);
        return student;
    }

    @Override
    public Student updateStudent(String id, StudentRequest request) {
        Student student=studentDocumentDao.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Student","student Id",request)
        );

        student.setStudentName(request.getStudentName());
        studentDocumentDao.save(student);
        return student;
    }

    @Override
    public void deleteById(String id) {
        studentDocumentDao.deleteById(id);
    }
}
