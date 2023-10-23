package com.myApp.products.controller;

import com.myApp.products.dto.ProductDTO;
import com.myApp.products.entity.Product;
import com.myApp.products.service.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductImpl service;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(service.saveProduct(productDTO), HttpStatus.CREATED);
    };

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id){
        return new ResponseEntity<>(service.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping("/id/{productId}")
    public ResponseEntity<Product> findById(@PathVariable UUID productId){
        return new ResponseEntity<>(service.findById(productId), HttpStatus.OK);
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<Product> updateCategory(@RequestBody Product product, @PathVariable int categoryId){
        return new ResponseEntity<>(service.updateProductCategory(product,categoryId),HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.updateProduct(product), HttpStatus.OK);
    }
}
