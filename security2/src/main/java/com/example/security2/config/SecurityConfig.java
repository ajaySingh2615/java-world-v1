package com.example.security2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
        System.out.println("Configuring SecurityFilterChain");
        http
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form -> form
                        .defaultSuccessUrl("/", true)  // redirect to home page after successful login
                        .failureUrl("/login?error")    // redirect to login with error parameter on failure
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/")         // redirect to home after logout
                        .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
