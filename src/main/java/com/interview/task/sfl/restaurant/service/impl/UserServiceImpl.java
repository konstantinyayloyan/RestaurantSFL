package com.interview.task.sfl.restaurant.service.impl;


import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.enums.UserType;
import com.interview.task.sfl.restaurant.repository.UserRepository;
import com.interview.task.sfl.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(@NotNull Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(@NotNull Long id) {
        userRepository.deleteById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User edit(@NotNull User user) {
        return userRepository.save(user);
    }
}
