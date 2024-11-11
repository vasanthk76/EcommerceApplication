package com.example.productservice.services;

import com.example.productservice.exceptions.InvalidIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public Product getProductById(long id) throws InvalidIdException {
        return productRepository.findById(id).orElseThrow(()->new InvalidIdException(id,"invalid product id "+id));
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by("price").descending()));
    }

    @Override
    public Product createProduct(Product product) {
        // System.out.println("product here"+product);
         Category category = product.getCategory();
         Category existingCategory = categoryRepository.findByTitle(category.getTitle()).orElse(null);
         if(existingCategory==null) {
             product.setCategory(categoryRepository.save(category));
         }else {
             product.setCategory(existingCategory);
         }
        return productRepository.save(product);
    }


    @Override
    public Product updateProduct(Long id,Product product) throws InvalidIdException{
        Product existingProduct = productRepository.findById(id).orElseThrow(()->new InvalidIdException(id,"invalid product id "+id));

        return null;
    }


    @Override
    public Product replaceProduct(Long id,Product product) {
        return null;
    }


    @Override
    public void deleteProduct(Long id) {

    }
}
