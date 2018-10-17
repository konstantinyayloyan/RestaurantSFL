package com.interview.task.sfl.restaurant.controller;

import com.interview.task.sfl.restaurant.model.common.LoginRequest;
import com.interview.task.sfl.restaurant.model.User;
import com.interview.task.sfl.restaurant.model.common.SuccessResponse;
import com.interview.task.sfl.restaurant.model.common.TokenResponse;
import com.interview.task.sfl.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(new TokenResponse(userService.signIn(request.getUsername(), request.getPassword())), HttpStatus.OK);
    }

    @PostMapping("/signup")
//    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public ResponseEntity<SuccessResponse> signUp(@RequestBody User user) {
        return new ResponseEntity<>(new SuccessResponse(userService.signUp(user)), HttpStatus.CREATED);
    }

}
