package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }


}
