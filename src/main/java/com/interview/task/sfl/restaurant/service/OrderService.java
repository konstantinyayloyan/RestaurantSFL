package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.Order;
import org.springframework.stereotype.Service;


@Service
public interface OrderService {

    Order create(Order order, Long tabelId) throws Exception;

    Order edit(Order order);
}
