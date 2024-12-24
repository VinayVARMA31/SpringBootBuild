package com.vinay.simpleWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import com.vinay.simpleWebApp.service.Product;
import com.vinay.simpleWebApp.model.Product;
import com.vinay.simpleWebApp.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<Product> getProduct(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping("/products")
    public void postProduct(@RequestBody Product product){
        service.addProduct(product);
    }
}
