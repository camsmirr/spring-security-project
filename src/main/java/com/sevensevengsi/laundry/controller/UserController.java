package com.sevensevengsi.laundry.controller;

import com.sevensevengsi.laundry.model.User;
import com.sevensevengsi.laundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        List <User> allUserList = userRepository.findAll();
        return allUserList;
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id){
        User user = userRepository.findById(id).get();
        return user;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id,
                                               @RequestBody User user) {
        User use = userRepository.findById(id).get();

        use.setEmail(user.getEmail());
        use.setName(user.getName());
        use.setUsername(user.getUsername());
        final User updatedUSer = userRepository.save(use);
        return ResponseEntity.ok(updatedUSer);
    }
}
