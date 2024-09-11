package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModelClass{
    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String image;
}
