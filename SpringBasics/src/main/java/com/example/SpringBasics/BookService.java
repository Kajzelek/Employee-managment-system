package com.example.SpringBasics;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    public BookService() {
        System.out.println("Book Service has been created");
    }
}
