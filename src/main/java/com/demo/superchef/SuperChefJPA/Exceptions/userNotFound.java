package com.demo.superchef.SuperChefJPA.Exceptions;

public class userNotFound extends RuntimeException{

    public userNotFound(String message) {
        super(message);
    }

    public userNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public userNotFound(Throwable cause) {
        super(cause);
    }
}
