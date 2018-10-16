package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantTableService {

    RestaurantTable create(RestaurantTable user);

    List<RestaurantTable> findByUserId(Long id);
}
