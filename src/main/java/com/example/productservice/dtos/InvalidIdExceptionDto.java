package com.example.productservice.dtos;

import lombok.Data;

@Data
public class InvalidIdExceptionDto {
    private String message;
    private String detail;
}
