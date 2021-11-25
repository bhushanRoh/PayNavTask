package com.bhus.cloud.studenteureka.dao;

import com.bhus.cloud.studenteureka.document.StudentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends MongoRepository<StudentDocument,String> {
}