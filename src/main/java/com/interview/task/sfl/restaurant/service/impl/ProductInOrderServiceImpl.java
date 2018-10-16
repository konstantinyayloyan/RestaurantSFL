package com.interview.task.sfl.restaurant.service.impl;


import com.interview.task.sfl.restaurant.model.ProductInOrder;
import com.interview.task.sfl.restaurant.repository.ProductInOrderRepository;
import com.interview.task.sfl.restaurant.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;


    @Override
    public ProductInOrder create(ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public ProductInOrder edit(ProductInOrder productInOrder) {
        return productInOrderRepository.save(productInOrder);
    }
}
