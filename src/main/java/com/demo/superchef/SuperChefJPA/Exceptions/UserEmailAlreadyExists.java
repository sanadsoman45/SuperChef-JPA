package com.demo.superchef.SuperChefJPA.Exceptions;

public class UserEmailAlreadyExists extends RuntimeException{

    public UserEmailAlreadyExists(String message) {
        super(message);
    }

    public UserEmailAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailAlreadyExists(Throwable cause) {
        super(cause);
    }
}
