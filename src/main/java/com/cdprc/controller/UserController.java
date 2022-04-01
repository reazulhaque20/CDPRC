package com.cdprc.controller;

import com.cdprc.model.Employees;
import com.cdprc.model.Files;
import com.cdprc.model.User;
import com.cdprc.repository.UserRepository;
import com.cdprc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> listAll() {

        List<Employees> eList = new ArrayList<>();
        List<Files> fList = new ArrayList<>();
        eList.add(new Employees("1","Alice"));
        eList.add(new Employees("2","John"));
        eList.add(new Employees("3","Jane"));
        eList.add(new Employees("4","Alice"));
        eList.add(new Employees("5","Bob"));

        fList.add(new Files("100","jpeg"));
        fList.add(new Files("Alice","png"));
        fList.add(new Files("3","jpg"));
        fList.add(new Files("1","jpg"));
        fList.add(new Files("John","jpeg"));

        int x = FileService.findFileTypesByEmpName(eList, fList);

        List<User> listUsers = userRepository.findAll();
        if(listUsers.size() > 0){
            return listUsers;
        }else{
            return null;
        }

    }
}
