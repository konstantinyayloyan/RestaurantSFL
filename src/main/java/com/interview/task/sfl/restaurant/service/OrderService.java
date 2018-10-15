package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order create(Order order);

    Order getOrder(Long id);

    List<Order> getOrders();

    Order findOrderByRestaurantTableAndStatus(RestaurantTable restaurantTable, OrderStatus orderStatus);

    void deleteById(Long id);

    Order edit(Order order);


}
