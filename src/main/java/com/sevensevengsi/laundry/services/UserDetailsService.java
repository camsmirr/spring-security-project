package com.sevensevengsi.laundry.services;

import com.sevensevengsi.laundry.model.User;
import com.sevensevengsi.laundry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository repository;

    public User saveUser (User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return (UserDetails) user;

    }
}
