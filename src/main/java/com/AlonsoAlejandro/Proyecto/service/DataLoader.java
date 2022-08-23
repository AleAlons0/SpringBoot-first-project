package com.AlonsoAlejandro.Proyecto.service;

import com.AlonsoAlejandro.Proyecto.persistence.entities.RoleUser;
import com.AlonsoAlejandro.Proyecto.persistence.entities.User;
import com.AlonsoAlejandro.Proyecto.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("Soyyo123");

        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("souyyo1234");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("Admin22");


        userRepository.save(new User("manuel_user", "manuel@gmail.com", hashedPassword, RoleUser.USER));
        userRepository.save(new User("marti_12", "martina@gmail.com", hashedPassword1, RoleUser.USER));
        userRepository.save(new User("alejo_mag", "alejandro@gmail.com", hashedPassword2, RoleUser.ADMIN));

    }
}
