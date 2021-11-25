package com.bhushan.studentservice.service;

import com.bhushan.studentservice.model.RequiredResponse;
import com.bhushan.studentservice.model.SchoolRequest;
import com.bhushan.studentservice.model.SchoolResponse;

public interface SchoolService {
    SchoolResponse saveSchool(SchoolRequest schoolRequest);

    SchoolResponse updateSchool(String schoolId, SchoolRequest request);

    RequiredResponse getSchoolById(String schoolId);

    void deleteById(String schoolId);
}
