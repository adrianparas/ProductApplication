package com.snva.product_ecommerce_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snva.product_ecommerce_app.entity.Product;
import com.snva.product_ecommerce_app.exception.InvalidProductException;
import com.snva.product_ecommerce_app.payload.request.ProductRequest;
import com.snva.product_ecommerce_app.payload.response.ProductResponse;
import com.snva.product_ecommerce_app.repository.ProductRepository;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public long createProduct(ProductRequest productRequest) throws InvalidProductException {
        Product product = Product.builder()
                            .name(productRequest.getName())
                            .price(productRequest.getPrice())
                            .imageUrl(productRequest.getImageUrl())
                            .description(productRequest.getDescription())
                            .category(productRequest.getCategory())
                            .build();
        try {
            product = productRepository.save(product);
        } catch(Exception e) {
            throw new InvalidProductException("Invalid product data", "INVALID_PRODUCT");
        }
        return product.getId();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse getProductById(Long id) throws InvalidProductException {
        Product product = productRepository.findById(id).orElseThrow(
            () -> new InvalidProductException("Product with id not found", "PRODUCT_NOT_FOUND"));
        ProductResponse response = new ProductResponse();
        copyProperties(product, response);
        return response;
    }

    @Override
    public void deleteProduct(Long id) throws InvalidProductException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new InvalidProductException("Product with id: " + id + " not found", "PRODUCT_NOT_FOUND");
        }
    }
    
}
