package com.bhushan.studentservice.service.impl;

import com.bhushan.studentservice.dao.SchoolDao;
import com.bhushan.studentservice.document.SchoolDocument;
import com.bhushan.studentservice.exception.ResourceNotFoundException;
import com.bhushan.studentservice.model.RequiredResponse;
import com.bhushan.studentservice.model.SchoolRequest;
import com.bhushan.studentservice.model.SchoolResponse;
import com.bhushan.studentservice.model.Student;
import com.bhushan.studentservice.service.SchoolService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SchoolDao schoolDao;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public SchoolResponse saveSchool(SchoolRequest schoolRequest) {
        SchoolDocument schoolDocument = objectMapper.convertValue(schoolRequest, SchoolDocument.class);
        schoolDao.save(schoolDocument);
        return objectMapper.convertValue(schoolDocument, SchoolResponse.class);
    }

    @Override
    public SchoolResponse updateSchool(String schoolId, SchoolRequest request) {
        SchoolDocument schoolDocument = schoolDao.findById(schoolId).orElseThrow(
                () ->new ResourceNotFoundException("School","schoolId",request)
        );

        schoolDocument.setSchoolName(request.getSchoolName());
        schoolDao.save(schoolDocument);
        return objectMapper.convertValue(schoolDocument, SchoolResponse.class);
    }

    @Override
    public RequiredResponse getSchoolById(String id) {
        RequiredResponse  requiredResponse=new RequiredResponse();
        SchoolDocument schoolDocument=schoolDao.findById(id).get();
        requiredResponse.setSchool(schoolDocument);

        List<Student> studentList=restTemplate.getForObject("http://STUDENT-EUREKA-SERVER/v1/student/{id}"+id, List.class);
        requiredResponse.setStudentList(studentList);
        return requiredResponse;
       /* Optional<SchoolDocument> studentDocument= schoolDao.findById(schoolId);
        if(studentDocument.isPresent()){
            return objectMapper.convertValue(studentDocument.get(), SchoolResponse.class);
        }
        else {
            throw new ResourceNotFoundException("School","schoolId",schoolId);
        }*/
    }

    @Override
    public void deleteById(String schoolId) {
       schoolDao.deleteById(schoolId);
    }

   /* private StudentDocument getStudentOrThrownNotFoundError(String studentId) {
        Optional<StudentDocument> studentDocument=studentDocumentDao.findById(studentId);
        if(!studentDocument.isPresent()){
            return null;
        }
        return studentDocument.get();
    }*/
}
