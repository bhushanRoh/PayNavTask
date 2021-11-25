package com.bhus.student.dao;

import com.bhus.student.document.StudentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends MongoRepository<StudentDocument,String> {
}