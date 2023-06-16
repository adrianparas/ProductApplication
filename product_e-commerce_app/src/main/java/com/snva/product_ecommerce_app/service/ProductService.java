package com.snva.product_ecommerce_app.service;

import java.util.List;

import com.snva.product_ecommerce_app.entity.Product;
import com.snva.product_ecommerce_app.exception.InvalidProductException;
import com.snva.product_ecommerce_app.payload.request.ProductRequest;
import com.snva.product_ecommerce_app.payload.response.ProductResponse;

public interface ProductService  {
    long createProduct(ProductRequest productRequest) throws InvalidProductException;

    List<Product> getAllProducts();

    ProductResponse getProductById(Long id) throws InvalidProductException;


    void deleteProduct(Long id) throws InvalidProductException;
    
}
