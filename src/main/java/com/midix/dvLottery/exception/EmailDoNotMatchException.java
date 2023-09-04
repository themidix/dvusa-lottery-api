package com.midix.dvLottery.exception;

public class EmailDoNotMatchException extends Exception {

    private String message;

    public EmailDoNotMatchException(String message) {
        super(message);
    }
}
