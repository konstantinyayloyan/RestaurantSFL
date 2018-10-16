package com.interview.task.sfl.restaurant.service;


import com.interview.task.sfl.restaurant.model.ProductInOrder;
import org.springframework.stereotype.Service;


@Service
public interface ProductInOrderService {

    ProductInOrder create(ProductInOrder productInOrder);

    ProductInOrder edit(ProductInOrder productInOrder);
}
