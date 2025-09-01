package com.example.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if(!username.equals("mike")){
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        String encodedPassword = new BCryptPasswordEncoder().encode("security");
//        return User.withUsername("mike")
//                .password(encodedPassword)
//                .roles("USER")
//                .build();

        String encodedPassword = new BCryptPasswordEncoder().encode("security");
        if (username.equals("mike")) {
            return User
                    .withUsername("mike")
                    .password(encodedPassword)
                    .roles("ADMIN")
                    .build();
        }

        String encodedPasswordRaj = new BCryptPasswordEncoder().encode("security");
        if (username.equals("raj")) {
            return User
                    .withUsername("raj")
                    .password(encodedPasswordRaj)
                    .roles("USER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found");
    }
}
