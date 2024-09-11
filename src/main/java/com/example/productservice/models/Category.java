package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModelClass{
    private String title;
}
