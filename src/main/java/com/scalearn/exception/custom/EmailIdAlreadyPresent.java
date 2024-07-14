package com.scalearn.exception.custom;

public class EmailIdAlreadyPresent extends Exception {
    public EmailIdAlreadyPresent() {
    }

    public EmailIdAlreadyPresent(String message) {
        super(message);
    }
}
