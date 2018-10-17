package com.interview.task.sfl.restaurant.service;

import com.interview.task.sfl.restaurant.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    String signIn(String username, String password);

    String signUp(User user);
}
