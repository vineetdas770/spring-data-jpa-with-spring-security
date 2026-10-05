package com.example.spring_data_jpa_complete.service;

import com.example.spring_data_jpa_complete.entity.Role;
import com.example.spring_data_jpa_complete.entity.Users;
import com.example.spring_data_jpa_complete.repository.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @authour vindas
 **/
@Service
public class AdminUserInitializer{

    @Bean
    public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(userDetailsRepository.findByUsername("admin").isEmpty()){
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(Role.ADMIN);

                userDetailsRepository.save(admin);
                System.out.println("Default Admin user created");
            }

            if(userDetailsRepository.findByUsername("user").isEmpty()){
                Users admin = new Users();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user123"));
                admin.setRole(Role.USER);

                userDetailsRepository.save(admin);
                System.out.println("Default user created");
            }
        };
    }
}
