package com.bhushan.studentservice.dao;

import com.bhushan.studentservice.document.SchoolDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends MongoRepository<SchoolDocument,String> {
}
