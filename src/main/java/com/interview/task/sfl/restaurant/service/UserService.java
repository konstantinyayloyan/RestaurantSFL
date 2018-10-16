package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.enums.UserType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findById(Long id);

    List<User> findAll();

    void deleteById(Long id);

    User create(User user);

    User edit(User user);

    String signIn(String username, String password);

    String signUp(User user);
}
