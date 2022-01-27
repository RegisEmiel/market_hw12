package com.geekbrains.market.services;

import com.geekbrains.market.entites.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
}
