package com.bhus.studentApp1.dao;

import com.bhus.studentApp1.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends MongoRepository<Student,String> {
}
