package com.bhus.student.service.impl;

import com.bhus.student.dao.StudentDao;
import com.bhus.student.document.StudentDocument;
import com.bhus.student.exception.ResourceNotFoundException;
import com.bhus.student.model.StudentRequest;
import com.bhus.student.model.StudentResponse;
import com.bhus.student.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentDao studentDocumentDao;


    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        StudentDocument studentDocument= objectMapper.convertValue(studentRequest,StudentDocument.class);
        studentDocumentDao.save(studentDocument);
        return objectMapper.convertValue(studentDocument,StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudent(String studentId, StudentRequest request) {
        StudentDocument studentDocument=studentDocumentDao.findById(studentId).orElseThrow(
                () ->new ResourceNotFoundException("Student","student Id",request)
        );

        studentDocument.setStudentName(request.getStudentName());
        studentDocumentDao.save(studentDocument);
        return objectMapper.convertValue(studentDocument,StudentResponse.class);
    }

    @Override
    public StudentResponse getStudentById(String studentId) {
        Optional<StudentDocument> studentDocument=studentDocumentDao.findById(studentId);
        if(studentDocument.isPresent()){
            return objectMapper.convertValue(studentDocument.get(),StudentResponse.class);
        }
        else {
            throw new ResourceNotFoundException("Student","student Id",studentId);
        }
    }

    @Override
    public void deleteById(String studentId) {
        studentDocumentDao.deleteById(studentId);
    }


}
