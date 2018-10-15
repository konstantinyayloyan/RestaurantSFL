package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.Product;
import com.interview.task.sfl.restaurant.repository.ProductRepository;
import com.interview.task.sfl.restaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(@NotNull Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product edit(@NotNull Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
