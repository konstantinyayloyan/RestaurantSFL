package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.repository.RestaurantTableRepository;
import com.interview.task.sfl.restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    @Autowired
    RestaurantTableRepository restaurantTableRepository;


    @Override
    public RestaurantTable create(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    @Override
    public List<RestaurantTable> findByUserId(Long id) {
        return restaurantTableRepository.findByEmployeeId(id);
    }
}
