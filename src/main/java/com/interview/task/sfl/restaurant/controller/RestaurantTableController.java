package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantTableController {

    @Autowired
    RestaurantTableService restaurantTableService;

    @PostMapping(value = "/tables")
    public ResponseEntity<RestaurantTable> createTable(RestaurantTable restaurantTable) {
        return new ResponseEntity<>(restaurantTableService.create(restaurantTable), HttpStatus.OK);
    }

    @PostMapping(value = "/tables/{userId}")
    public ResponseEntity<List<RestaurantTable>> findByUserId(@PathVariable("userId") Long id) {
        return new ResponseEntity<>(restaurantTableService.findByUserId(id), HttpStatus.OK);
    }
}