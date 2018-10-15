package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;
import com.interview.task.sfl.restaurant.repository.OrderRepository;
import com.interview.task.sfl.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(@NotNull Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderByRestaurantTableAndStatus(RestaurantTable restaurantTable, OrderStatus orderStatus) {
        return null;
    }

    @Override
    public void deleteById(@NotNull Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order edit(@NotNull Order order) {
        return orderRepository.save(order);
    }
}
