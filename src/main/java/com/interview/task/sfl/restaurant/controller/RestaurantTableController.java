package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables/")
public class RestaurantTableController {

    @Autowired
    RestaurantTableService restaurantTableService;

    @PostMapping(value = "/table")
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public ResponseEntity<RestaurantTable> createTable(RestaurantTable restaurantTable) {
        return new ResponseEntity<>(restaurantTableService.create(restaurantTable), HttpStatus.OK);
    }

    @PostMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('ROLE_WAITER')")
    public ResponseEntity<List<RestaurantTable>> findByUserId(@PathVariable("userId") Long id) {
        return new ResponseEntity<>(restaurantTableService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/{tableId}")
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public ResponseEntity<String> assignTableToUser(@PathVariable("userId") Long userId,
                                              @PathVariable("tableId") Long tableId) {
        try {
            restaurantTableService.assignTableToUser(tableId, userId);
        }

        catch (Exception e) {
            return new ResponseEntity<>("Unable to assign user with " + userId + " to table with " + tableId,
                    HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity <>("Successful assignment", HttpStatus.OK);

    }
}