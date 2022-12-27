package com.sevensevengsi.springsecurity.entity;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user_table", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "user_table_uk", columnNames = "username") })
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "username", length = 36, nullable = false)
    private String userName;

    @Column(name = "user_pass", length = 128, nullable = false)
    private String password;

    public User(String userName, String password, List<GrantedAuthority> grantList) {
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
