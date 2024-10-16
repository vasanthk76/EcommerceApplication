package com.example.productservice.dtos;

import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String username;
    private String email;
    private List<Role> roles;
    private Boolean isVerified;
}