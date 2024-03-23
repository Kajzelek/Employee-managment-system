package com.JavaExampleProjects.emsbackend.Exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException (String message){
        super(message);
    }
}
