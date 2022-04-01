package com.cdprc.controller;

import com.cdprc.model.User;
import com.cdprc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listAll() {
        List<User> listUsers = userRepository.findAll();
        if(listUsers.size() > 0){
            return listUsers;
        }else{
            return null;
        }

    }
}
