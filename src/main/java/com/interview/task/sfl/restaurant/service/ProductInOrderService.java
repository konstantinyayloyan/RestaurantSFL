package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.ProductInOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInOrderService {
    ProductInOrder save(ProductInOrder productInOrder);

    ProductInOrder getProductInOrder(Long id);

    void deleteById(Long id);

    ProductInOrder edit(ProductInOrder productInOrder);

    List<ProductInOrder> findAll();
}
