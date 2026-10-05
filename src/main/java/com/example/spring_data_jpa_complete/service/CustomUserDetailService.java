package com.example.spring_data_jpa_complete.service;

import com.example.spring_data_jpa_complete.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @authour vindas
 **/
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userDetailsRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username not found : "+username));
    }
}
