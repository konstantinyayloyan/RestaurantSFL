package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.ProductInOrder;
import com.interview.task.sfl.restaurant.repository.ProductInOrderRepository;
import com.interview.task.sfl.restaurant.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Override
    public ProductInOrder save(ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public ProductInOrder getProductInOrder(@NotNull Long id) {
        return productInOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(@NotNull Long id) {
        productInOrderRepository.deleteById(id);
    }

    @Override
    public ProductInOrder edit(@NotNull ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public List<ProductInOrder> findAll() {
        return productInOrderRepository.findAll();
    }
}
