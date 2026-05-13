package com.user.controller;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;
    private UserMapper mapper;

    @PostMapping(path = "/register")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest user){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(service.createUser(user)));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody UserRequest user){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(service.createUser(user)));
    }
}
