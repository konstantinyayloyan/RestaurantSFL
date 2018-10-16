package com.interview.task.sfl.restaurant.service.impl;


import com.interview.task.sfl.restaurant.exception.CustomException;
import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.enums.UserType;
import com.interview.task.sfl.restaurant.repository.UserRepository;
import com.interview.task.sfl.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

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



    public String signIn(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String uUID = UUID.randomUUID().toString();
            User user = userRepository.findByUsername(username);
            user.setUUID(uUID);
            return  uUID;
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signUp(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String uUID = UUID.randomUUID().toString();
            user.setUUID(uUID);
            userRepository.save(user);
            return uUID;
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
