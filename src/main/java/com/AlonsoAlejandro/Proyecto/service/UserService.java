package com.AlonsoAlejandro.Proyecto.service;

import com.AlonsoAlejandro.Proyecto.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserService implements UserDetailsService {
    private final com.AlonsoAlejandro.Proyecto.persistence.repository.UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByUsername(username).get();
    }
}
