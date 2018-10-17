package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productsInOrder/")
public class ProductInOrderController {


    @Autowired
    ProductInOrderService productInOrderService;

//    @PostMapping(value = "/tables")
//    public ResponseEntity<RestaurantTable> createTable(ProductInOrder productInOrder) {
//        return new ResponseEntity<>(productInOrderService.create(productInOrder), HttpStatus.OK);
//    }
}
