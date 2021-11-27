package com.bhus.libraryApplication.controller;

import com.bhus.libraryApplication.dao.BookDao;
import com.bhus.libraryApplication.document.BookDocument;
import com.bhus.libraryApplication.models.BookRequest;
import com.bhus.libraryApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RequestMapping("/v1")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookDao bookDao;

    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody BookRequest bookRequest){
        return new ResponseEntity<>(bookService.saveBook(bookRequest), HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody BookRequest request){
        return new ResponseEntity<>(bookService.updateBook(id,request),HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/book/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getBookById(@PathVariable final String id){
        return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/book/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteBookById(@PathVariable final String id){
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT);
    }
}
