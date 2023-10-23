package com.myApp.products.repository;

import com.myApp.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    public Product findProductByProductId(UUID productId);
    public void deleteByProductId(UUID productId);
}
