package com.sevensevengsi.springsecurity.controller;

import com.sevensevengsi.springsecurity.model.User;
import com.sevensevengsi.springsecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUser() {
        List<User> allUserlist = userRepository.findAll();
        return allUserlist;
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        User user = userRepository.findById(id).get();

        return user;
    }

    @PostMapping("/createUser")
   public User createEmployee(@RequestBody User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }
}
