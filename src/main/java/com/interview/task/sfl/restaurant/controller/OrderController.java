package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.model.enums.OrderStatus;
import com.interview.task.sfl.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/orders")
    public ResponseEntity<Order> createOrderForTable(Order order, Long tableId){
        try {
            orderService.create(order, tableId);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
