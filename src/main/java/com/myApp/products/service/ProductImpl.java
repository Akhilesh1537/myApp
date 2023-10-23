package com.myApp.products.service;

import com.myApp.products.dto.ProductDTO;
import com.myApp.products.entity.Product;
import com.myApp.products.mapper.ProductMapper;
import com.myApp.products.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductImpl{

    @Autowired
    ProductRepo productRepo;

    public Product saveProduct(ProductDTO productDTO) {
        var product = ProductMapper.INSTANCE.productDTOToProduct(productDTO);
        return productRepo.save(product);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product updateProductCategory(Product product, Integer category) {
        Product prd = productRepo.findProductByProductId(product.getProductId());
        prd.setCategory(category);
        return productRepo.save(prd);
    }

    public String deleteProduct(UUID id) {
        productRepo.deleteByProductId(id);
        return "Product Deleted";
    }

    public Product findById(UUID id){
        return productRepo.findProductByProductId(id);
    }

    public Product updateProduct(Product product){
        Product prd = productRepo.findProductByProductId(product.getProductId());
        prd.setProductId(product.getProductId());
        prd.setProductName(product.getProductName());
        prd.setQuantity(product.getQuantity());
        prd.setPrice(product.getPrice());
        prd.setCategory(product.getCategory());
        return productRepo.save(prd);
    }
}
