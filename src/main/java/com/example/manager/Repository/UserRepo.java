package com.example.manager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manager.Model.User;

public interface  UserRepo extends JpaRepository<User,Integer>{

    org.apache.catalina.User save(org.apache.catalina.User existingUse);
    Optional<User> findByUsername(String username);
}
    
