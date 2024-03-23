package com.example.SpringBasics;

import org.springframework.stereotype.Component;

@Component
public class BookRepository {
    public BookRepository() {
        System.out.println("Book Repository has been created");
    }
}
