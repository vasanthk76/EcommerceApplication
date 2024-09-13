package com.example.productservice.exceptions;

import lombok.Getter;

@Getter
public class InvalidIdException extends Exception {
    private long id;
    public InvalidIdException(Long id,String e) {
        super(e);
        this.id = id;
    }
}
