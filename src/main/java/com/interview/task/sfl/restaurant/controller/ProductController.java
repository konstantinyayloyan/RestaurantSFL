package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.Product;
import com.interview.task.sfl.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products",method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(Product product){
        return new ResponseEntity<>(productService.create(product), HttpStatus.OK);
    }
}
