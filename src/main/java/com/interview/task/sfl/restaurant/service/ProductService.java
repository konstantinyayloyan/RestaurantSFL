package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product create(Product product);

    Product findById(Long id);

    void deleteById(Long id);

    Product edit(Product product);

    List<Product> findAll();

}

