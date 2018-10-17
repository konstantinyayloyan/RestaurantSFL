package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.Product;
import com.interview.task.sfl.restaurant.repository.ProductRepository;
import com.interview.task.sfl.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotNull;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(@NotNull Product product) {
        return productRepository.save(product);
    }

}
