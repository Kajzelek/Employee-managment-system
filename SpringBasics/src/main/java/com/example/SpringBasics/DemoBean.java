package com.example.SpringBasics;

import org.springframework.stereotype.Component;

@Component
public class DemoBean {
    public DemoBean(){
        System.out.println("This is object ggets created by spring");
    }
}
