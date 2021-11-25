package com.bhus.cloud.studenteureka.service;

import com.bhus.cloud.studenteureka.dao.StudentDao;
import com.bhus.cloud.studenteureka.document.StudentDocument;
import com.bhus.cloud.studenteureka.exception.ResourceNotFoundException;
import com.bhus.cloud.studenteureka.model.StudentRequest;
import com.bhus.cloud.studenteureka.model.StudentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

   /* private StudentDocument getStudentOrThrownNotFoundError(String studentId) {
        Optional<StudentDocument> studentDocument=studentDocumentDao.findById(studentId);
        if(!studentDocument.isPresent()){
            return null;
        }
        return studentDocument.get();
    }*/
}
