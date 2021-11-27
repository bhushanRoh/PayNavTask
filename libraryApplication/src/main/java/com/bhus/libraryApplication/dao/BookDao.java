package com.bhus.libraryApplication.dao;

import com.bhus.libraryApplication.document.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends MongoRepository<BookDocument,String> {
}
