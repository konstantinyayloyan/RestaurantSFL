package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.LoginRequest;
import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.enums.UserType;
import com.interview.task.sfl.restaurant.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    @PreAuthorize("hasRole(ROLE_MANAGER)")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = new User();
        user.setUUID(UUID.randomUUID().toString());
        user.setPassword("12235353446");
        user.setFirstName("firstname");
        user.setLastName("firstname");
        user.setUsername("username");
        user.setUserType(UserType.ROLE_MANAGER);
        return new ResponseEntity<>(/*userService.findById(id)*/user, HttpStatus.OK);
    }


    @PostMapping("users/signin")
    public String login(@RequestBody LoginRequest request
    ) {
        return userService.signIn(request.getUsername(), request.getPassword());
    }

    @PostMapping("users/signup")
    public String signUp(@RequestBody User user) {
        return userService.signUp(user);
    }


}
