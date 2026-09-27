package com.ga.Todo.repository;

import com.ga.Todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //For Registration
    boolean existsByEmailAddress(String emailAddress);

    //For Login
    User findUserByEmailAddress(String emailAddress);
}
