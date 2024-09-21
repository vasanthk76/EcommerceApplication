package com.example.productservice.advices;

import com.example.productservice.dtos.ArithmaticExceptionDto;
import com.example.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.example.productservice.dtos.InvalidIdExceptionDto;
import com.example.productservice.exceptions.InvalidIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmaticExceptionDto> handleArithmaticException() {
        ArithmaticExceptionDto dto = new ArithmaticExceptionDto();
        dto.setMessage("Arithmetic Exception");
        dto.setDetail("Arithmetic Exception detail");
        return new ResponseEntity<ArithmaticExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<InvalidIdExceptionDto> handleInvalidIdException(InvalidIdException e) {
        InvalidIdExceptionDto dto = new InvalidIdExceptionDto();
        dto.setMessage("Invalid id");
        dto.setDetail(e.getMessage());
        dto.setId(e.getId());
        return new ResponseEntity<InvalidIdExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleArrayIndexOutOfBoundsException() {
        ArrayIndexOutOfBoundExceptionDto dto = new ArrayIndexOutOfBoundExceptionDto();
        dto.setMessage("null pointer exception");
        dto.setDetail("null pointer exception detail");
        return new ResponseEntity<ArrayIndexOutOfBoundExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }
}
