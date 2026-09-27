package com.ga.Todo.controller;

import com.ga.Todo.model.User;
import com.ga.Todo.model.request.LoginRequest;
import com.ga.Todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/auth/users")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody User userobject){
        System.out.println("Calling createUser ==> ");
        return userService.createUser(userobject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println("Calling loginUser ==> ");
        return userService.loginUser(loginRequest);
    }

}
