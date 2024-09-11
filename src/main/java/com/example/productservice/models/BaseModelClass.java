package com.example.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseModelClass {
    @Id
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
