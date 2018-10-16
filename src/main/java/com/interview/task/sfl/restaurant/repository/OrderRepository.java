package com.interview.task.sfl.restaurant.repository;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getOrderByStatusAndRestaurantTable(OrderStatus status, RestaurantTable restaurantTable);
}
