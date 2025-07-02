package com.foreign.team.toy.store.exceptions;
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
