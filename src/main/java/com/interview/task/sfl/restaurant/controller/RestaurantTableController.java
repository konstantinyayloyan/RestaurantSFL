package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantTableController {

    @Autowired
    RestaurantTableService restaurantTableService;

    @RequestMapping(value = "/tables",method = RequestMethod.POST)
    public ResponseEntity<RestaurantTable> createTable(RestaurantTable restaurantTable ){
        return new ResponseEntity<>(restaurantTableService.create(restaurantTable), HttpStatus.OK);
    }
}
