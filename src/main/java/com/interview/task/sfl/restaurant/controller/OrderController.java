package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.Order;
import com.interview.task.sfl.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order/create")
    @PreAuthorize("hasAuthority('ROLE_WAITER')")
    public ResponseEntity<Order> createOrderForTable(Order order, Long tableId){
        try {
            orderService.create(order, tableId);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping(value = "/order/edit")
    @PreAuthorize("hasAuthority('ROLE_WAITER')")
    public ResponseEntity<Order> editOrder(Order order){
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
