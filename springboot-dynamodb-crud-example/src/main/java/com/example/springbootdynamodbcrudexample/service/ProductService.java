package com.example.springbootdynamodbcrudexample.service;

import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.springbootdynamodbcrudexample.model.Product;

@Service
public class ProductService {

    private final DynamoDBMapper dynamoDBMapper;

    public ProductService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Product createProduct(Product product) {
        dynamoDBMapper.save(product);
        return product;
    }

    public Product getProductById(String productId) {
        return dynamoDBMapper.load(Product.class, productId);
    }

    public void updateProduct(Product product) {
        dynamoDBMapper.save(product);
    }

    public void deleteProduct(String productId) {
        Product productToDelete = getProductById(productId);
        if (productToDelete != null) {
            dynamoDBMapper.delete(productToDelete);
        } else {
            // Handle case where product with the ID is not found (optional)
        }
    }

}