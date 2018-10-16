package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;
import com.interview.task.sfl.restaurant.repository.OrderRepository;
import com.interview.task.sfl.restaurant.repository.RestaurantTableRepository;
import com.interview.task.sfl.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @Override
    public Order create(Order order, Long tableId) throws Exception {

        RestaurantTable restaurantTable = restaurantTableRepository.getOne(tableId);
        if(orderRepository.getOrderByStatusAndRestaurantTable(OrderStatus.OPEN, restaurantTable) != null) {
            throw new Exception("Table is busy");
        }

        order.setRestaurantTable(restaurantTable);
        order.setStatus(OrderStatus.OPEN);

        return orderRepository.save(order);
    }

    @Override
    public Order edit(Order order) {
        return orderRepository.save(order);
    }

}
