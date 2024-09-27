package com.example.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModelClass{
    private String title;
    private Double price;
    private String description;
    @ManyToOne(cascade=CascadeType.MERGE)
    private Category category;
    private String image;
//    private int quantity;
}
