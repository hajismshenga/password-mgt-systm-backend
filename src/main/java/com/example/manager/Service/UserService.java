package com.example.manager.Service;



import java.util.List;
import java.util.Optional;
import com.example.manager.Model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manager.Repository.UserRepo;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User addUser(User use){
        return userRepo.save(use);
    }

    public User getUserById(int useId){
        Optional<User> optionalUser = userRepo.findById(useId);
        return optionalUser.get();
    }
    
    public void deleteUser(int useId) {
        userRepo.deleteById(useId);
    }


    public User updateUser(User use) {
        User existingUse = userRepo.findById(use.getId()).get();
        existingUse.setUsername(use.getUsername());
        existingUse.setPassword(use.getPassword());
        User updateUser = userRepo.save(existingUse);
        return updateUser;
}

    
    public Optional<User> getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    } 

}   

