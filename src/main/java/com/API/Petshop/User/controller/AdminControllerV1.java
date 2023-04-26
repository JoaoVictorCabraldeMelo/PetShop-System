package com.API.Petshop.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.Petshop.User.services.UserService;
import com.API.Petshop.User.services.UserResponse;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminControllerV1 {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> returnAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
