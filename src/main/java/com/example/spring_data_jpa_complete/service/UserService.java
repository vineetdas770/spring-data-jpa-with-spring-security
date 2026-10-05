package com.example.spring_data_jpa_complete.service;

import com.example.spring_data_jpa_complete.entity.RegisterUserRequest;
import com.example.spring_data_jpa_complete.entity.UserResponse;
import com.example.spring_data_jpa_complete.entity.Users;
import com.example.spring_data_jpa_complete.repository.UserDetailsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @authour vindas
 **/
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsRepository userDetailsRepository;

    public UserService(PasswordEncoder passwordEncoder, UserDetailsRepository userDetailsRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsRepository = userDetailsRepository;
    }

    public UserResponse registerUser(RegisterUserRequest registerUserRequest){
        //TODO - check if user is already present
        if(userDetailsRepository.findByUsername(registerUserRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already exists");
        }
        //TODO - encode password in request
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setRole(registerUserRequest.getRole());
        users.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        //TODO - save user
        Users savedUser = userDetailsRepository.save(users);
        return new UserResponse(savedUser.getId(),savedUser.getUsername(),savedUser.getRole().name());
    }
}
