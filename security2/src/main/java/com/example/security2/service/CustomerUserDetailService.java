package com.example.security2.service;

import com.example.security2.entity.User;
import com.example.security2.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomerUserDetailService implements UserDetailsService { // implement interface

    private final UserRepository userRepository;

    public CustomerUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override // explicit override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true, true, true, true,
                user.getRoles().stream()
                        .map(role -> new
                                org.springframework.security.core.authority.SimpleGrantedAuthority(
                                        role.getName().startsWith("ROLE_") ? role.getName() : "ROLE_" + role.getName())) // ensure ROLE_ prefix
                        .collect(Collectors.toSet())
        );
    }
}
