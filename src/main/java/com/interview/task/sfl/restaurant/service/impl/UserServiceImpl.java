package com.interview.task.sfl.restaurant.service.impl;


import com.interview.task.sfl.restaurant.exception.CustomException;
import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.repository.UserRepository;
import com.interview.task.sfl.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String signIn(String username, String password) {
        String uUID = UUID.randomUUID().toString().replaceAll("-","");
        User user = userRepository.findByUsername(username);
        if(user != null && passwordEncoder.matches(password,user.getPassword())){
            user.setUUID(uUID);
            return  uUID;
        }else {
            throw new UsernameNotFoundException("Username or Password is incorrect");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String signUp(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "Registration is success";
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
