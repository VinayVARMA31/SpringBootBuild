package com.vinay.simpleWebApp.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.vinay.simpleWebApp.model.Product;

@Service
public class ProductService {

    List<Product> products =new ArrayList<>( Arrays.asList(
    new Product(1, "Laptop", 1000),
    new Product(2, "Mobile", 500),
    new Product(3, "Tablet", 300)));

    public List<Product> getProducts(){
    
    return products; 
    }

    public Product getProduct(int id) {
        return products.stream().filter(p->p.getId()==id).findFirst().orElse(new Product(0,"No Product",0));
    }

    public void addProduct(Product product) {
      products.add(product);
    }

    public void updateProduct(Product product) {
       int index = 0;
       for (int i = 0; i < products.size(); i++) {
        if (products.get(i).getId() == product.getId()) {
            index = i;
            break; 
        }
        products.set(index, product);
       }
    }

    public void deleteProduct(int id) {
        products.removeIf(p->p.getId()==id);
    }
}
