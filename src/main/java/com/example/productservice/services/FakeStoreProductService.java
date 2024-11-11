package com.example.productservice.services;

import com.example.productservice.dtos.FakeProductDto;
import com.example.productservice.exceptions.InvalidIdException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(long id) throws InvalidIdException{

        FakeProductDto fakeProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeProductDto.class);
        System.out.println(fakeProductDto);
        if(fakeProductDto == null) {
            throw new InvalidIdException(id,"ID given: "+id);
        }
        return converToProduct(fakeProductDto);
    }

    @Override
    public Page<Product> getAllProducts(int page,int size) {
        FakeProductDto[] fakeProductDto = restTemplate.getForObject("https://fakestoreapi.com/products",FakeProductDto[].class);

        List<Product> products = new ArrayList<>();

        for(FakeProductDto fakeProductDto1 : fakeProductDto){
            products.add(converToProduct(fakeProductDto1));
        }

        return new PageImpl<>(products);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        return null;
    }


    @Override
    public Product replaceProduct(Long id, Product product) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeProductDto.class);
        HttpMessageConverterExtractor<FakeProductDto> responseExtractor = new HttpMessageConverterExtractor<>(FakeProductDto.class, restTemplate.getMessageConverters());
        FakeProductDto fakeProductDto = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return converToProduct(fakeProductDto);
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product converToProduct(FakeProductDto fakeProductDto) {
        Product product = new Product();
        product.setId(fakeProductDto.getId());
        product.setTitle(fakeProductDto.getTitle());
        product.setImage(fakeProductDto.getImage());
        product.setDescription(fakeProductDto.getDescription());
        product.setPrice(fakeProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
