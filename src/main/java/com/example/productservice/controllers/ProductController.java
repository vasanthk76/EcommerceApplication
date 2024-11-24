package com.example.productservice.controllers;

import com.example.productservice.commons.AuthenticationCommons;
import com.example.productservice.dtos.UserDto;
import com.example.productservice.exceptions.InvalidIdException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthenticationCommons authenticationCommons;
    private RestTemplate restTemplate;

    ProductController(ProductService productService, AuthenticationCommons authenticationCommons, RestTemplate restTemplate) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws InvalidIdException,NullPointerException {
        Product product = productService.getProductById(id);

        ResponseEntity<String> response = restTemplate.getForEntity("http://userservice/users/10", String.class);

        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
//
//    @GetMapping("/{token}")
//    public ResponseEntity<List<Product>> getAllProducts(@PathVariable String token) {
//        UserDto userDto = authenticationCommons.validateToken(token);
//
//        if(userDto==null){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        if(userDto.getRoles().stream().anyMatch(role -> role.getRoleName().equals("ADMIN"))){
//            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//    }


    @GetMapping("/")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
            return new ResponseEntity<>(productService.getAllProducts(pageNumber,pageSize), HttpStatus.OK);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) throws InvalidIdException{
        Product updatedProduct = productService.updateProduct(id,product);
        return new ResponseEntity<>(updatedProduct, HttpStatusCode.valueOf(200));
    }

    @PutMapping
    public Product replaceProduct(@RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

}