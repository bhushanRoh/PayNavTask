package com.bhus.libraryApplication.service;

import com.bhus.libraryApplication.document.BookDocument;
import com.bhus.libraryApplication.models.BookRequest;

import java.awt.print.Book;

public interface BookService {
    BookDocument saveBook(BookRequest bookRequest);

    BookDocument updateBook(String id, BookRequest request);

    void deleteById(String id);

    BookDocument getBookById(String id);
}
