package com.example.manager.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manager.Model.User;
import com.example.manager.Service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")

public class UserAPI {

    @Autowired
    private UserService userService;
    private int useId;
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> use = userService.getAllUsers();
        return new ResponseEntity<>(use, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User use){
    User savedUser = userService.addUser(use);
    return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping("/userById/{Id}")
    public ResponseEntity<User> getUserById(@PathVariable("Id") int userId)
    {
        User use = userService.getUserById(useId);
        return new ResponseEntity<>(use, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("Id") int useId)
    {
        userService.deleteUser(useId);
        return new ResponseEntity<String>("user deleted success", HttpStatus.OK);
    }
    
    @PutMapping("/update/{Id}")
    public ResponseEntity<User> updateUser(@PathVariable("Id") int useId, @RequestBody User use){
        use.setId(useId);
        User useUpdate = userService.updateUser(use);
        return new ResponseEntity<>(useUpdate, HttpStatus.CREATED);
    }
    
@GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
       
    }
   
}
