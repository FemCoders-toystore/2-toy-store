package com.foreign.team.toy.store.exceptions;
public class CartAlreadyExistsException extends RuntimeException {
    public CartAlreadyExistsException(String message) {
        super(message);
    }
}

