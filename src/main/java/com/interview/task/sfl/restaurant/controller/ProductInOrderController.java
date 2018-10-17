package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.ProductInOrder;
import com.interview.task.sfl.restaurant.service.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productsInOrder/")
public class ProductInOrderController {


    @Autowired
    ProductInOrderService productInOrderService;

    @PostMapping(value = "/productInOrder/create")
    @PreAuthorize("hasAuthority('ROLE_WAITER')")
    public ResponseEntity<ProductInOrder> edit(ProductInOrder productInOrder) {
        return new ResponseEntity<>(productInOrderService.edit(productInOrder), HttpStatus.OK);
    }
}
