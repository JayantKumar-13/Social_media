package com.example.questionapp.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {  //kendi exception mesajimiz için
        super(message);
    }
}
