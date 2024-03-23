package com.example.SpringBasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryService{

    private BookService bookService;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(BookService bookService, BookRepository bookRepository) {
        System.out.println("Library Service has been created");
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }
}
