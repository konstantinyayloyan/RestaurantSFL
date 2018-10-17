package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.Product;
import com.interview.task.sfl.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public ResponseEntity<Product> addProduct(Product product){
        return new ResponseEntity<>(productService.create(product), HttpStatus.OK);
    }
}
