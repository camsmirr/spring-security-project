package com.sevensevengsi.laundry.repository;

import com.sevensevengsi.laundry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUsername(String username);
}

