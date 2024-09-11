package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidIdException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws InvalidIdException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product replaceProduct(Product product);

    Product replaceProduct(long id, Product product);

    void deleteProduct(long id);
}
