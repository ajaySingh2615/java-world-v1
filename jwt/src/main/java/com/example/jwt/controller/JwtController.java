package com.example.jwt.controller;

import com.example.jwt.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class JwtController {

    private final JwtUtil jwtUtil;

    public JwtController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/generate-token")
    public String generateToken(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            // generate
            return jwtUtil.generateToken(username);
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/fund-transfer")
    public String fundTransfer(@RequestHeader(value = "Authorization", required = false) String
                                       authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            if (jwtUtil.validateToken(token)) {
                return "this is secure fund transfer";
            } else {
                return "Invalid or expired token";
            }
        } else {
            return "Authorization header missing or invalid";
        }
    }
}
