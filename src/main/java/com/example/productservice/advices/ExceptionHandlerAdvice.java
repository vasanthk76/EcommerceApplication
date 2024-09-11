package com.example.productservice.advices;

import com.example.productservice.dtos.ArithmaticExceptionDto;
import com.example.productservice.dtos.ArrayIndexOutOfBoundExceptionDto;
import com.example.productservice.dtos.InvalidIdExceptionDto;
import com.example.productservice.exceptions.InvalidIdException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmaticExceptionDto> handleArithmaticException() {
        ArithmaticExceptionDto dto = new ArithmaticExceptionDto();
        dto.setMessage("Arithmetic Exception");
        dto.setDetail("you F'd up");
        return new ResponseEntity<ArithmaticExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<InvalidIdExceptionDto> handleInvalidIdException(InvalidIdException e) {
        InvalidIdExceptionDto dto = new InvalidIdExceptionDto();
        dto.setMessage("Invalid id");
        dto.setDetail(e.getMessage());
        return new ResponseEntity<InvalidIdExceptionDto>(dto, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public ResponseEntity<ArrayIndexOutOfBoundExceptionDto> handleArrayIndexOutOfBoundsException() {
//        ArrayIndexOutOfBoundExceptionDto dto = new ArrayIndexOutOfBoundExceptionDto();
//        dto.setMessage("ArrayIndexOutOfBoundsException");
//        return new ResponseEntity<ArrayIndexOutOfBoundExceptionDto>(dto, HttpStatus.BAD_REQUEST);
//    }
}
