package com.bhus.libraryApplication.service.impl;

import com.bhus.libraryApplication.dao.BookDao;
import com.bhus.libraryApplication.document.BookDocument;
import com.bhus.libraryApplication.exception.ResourceNotFoundException;
import com.bhus.libraryApplication.models.BookRequest;
import com.bhus.libraryApplication.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    BookDao bookDao;


    @Override
    public BookDocument saveBook(BookRequest bookRequest) {
        BookDocument bookDocument= objectMapper.convertValue(bookRequest,BookDocument.class);
        bookDao.save(bookDocument);
        return bookDocument;
    }

    @Override
    @CachePut(cacheNames = "book",key="#id")
    public BookDocument updateBook(String id, BookRequest request) {
        BookDocument bookDocument=bookDao.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Book","id",request)
        );

        bookDocument.setName(request.getName());
        bookDocument.setAuthor(request.getAuthor());
        bookDao.save(bookDocument);
        return bookDocument;
    }

    @Override
    @CacheEvict(cacheNames = "book",key = "#id")
    public void deleteById(String id) {
        bookDao.deleteById(id);
    }

    @Override
    @Cacheable(cacheNames = "book",key = "#id")
    public BookDocument getBookById(String id) {
        Optional<BookDocument> bookDocument=bookDao.findById(id);
        if(bookDocument.isPresent()){
            return bookDocument.get();
        }
        else {
            throw new ResourceNotFoundException("Book","Id",id);
        }
    }
}
