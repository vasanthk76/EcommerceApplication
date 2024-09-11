package com.example.productservice.dtos;

import lombok.Data;

@Data
public class FakeProductDto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
