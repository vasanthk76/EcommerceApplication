package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidIdException;
import com.example.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws InvalidIdException;
    Page<Product> getAllProducts(int pageNumber, int pageSize) ;
    Product createProduct(Product product);
    Product updateProduct(Long id,Product product) throws InvalidIdException;
    Product replaceProduct(Long id,Product product) throws InvalidIdException;

    void deleteProduct(Long id);
}
