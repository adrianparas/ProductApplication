package com.snva.product_ecommerce_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.snva.product_ecommerce_app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
