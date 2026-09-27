package com.ga.Todo.service;

import com.ga.Todo.model.User;
import com.ga.Todo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public User createUser(User userObject){
        System.out.println("Service Calling createUser ==> ");
        return userRepository.save(userObject);

    }

}
