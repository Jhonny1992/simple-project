package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUser(){
        List<User> obj = userService.findAll();
        return ResponseEntity.ok(obj);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User obj = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
}
