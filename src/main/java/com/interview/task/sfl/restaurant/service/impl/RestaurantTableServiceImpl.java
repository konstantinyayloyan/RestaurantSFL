package com.interview.task.sfl.restaurant.service.impl;

import com.interview.task.sfl.restaurant.model.RestaurantTable;
import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.repository.RestaurantTableRepository;
import com.interview.task.sfl.restaurant.repository.UserRepository;
import com.interview.task.sfl.restaurant.service.RestaurantTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private Logger LOGGER = LoggerFactory.getLogger(RestaurantTableServiceImpl.class);

    private RestaurantTableRepository restaurantTableRepository;
    private UserRepository userRepository;

    @Autowired
    public RestaurantTableServiceImpl(RestaurantTableRepository restaurantTableRepository, UserRepository userRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.userRepository = userRepository;
    }

    @Override
    public RestaurantTable create(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    @Override
    public List<RestaurantTable> findByUserId(Long id) {
        return restaurantTableRepository.findByUserId(id);
    }


    @Override
    @Transactional
    public void assignTableToUser(Long tableId, Long userId) throws Exception{
        LOGGER.info("Trying to assign table with id {} to user with id {}", tableId, userId);

        RestaurantTable restaurantTable = restaurantTableRepository.getOne(tableId);

        if (restaurantTable == null) {
            throw new Exception("Table does not exist");
        } else if (restaurantTable.getUser() != null) {
            throw new Exception("Table already has assignee");
        }

        User user = userRepository.getOne(userId);

        if (user == null) {
            throw new Exception("User with id does not exist");
        }
        restaurantTable.setUser(user);
    }
}
