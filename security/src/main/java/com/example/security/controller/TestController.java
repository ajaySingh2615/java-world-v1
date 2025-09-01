package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String index() {
        return "index security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String indexAdmin() {
        return "admin security";
    }

    @GetMapping("/about-us")
    public String aboutUs() {
        return "about us security";
    }

    @GetMapping("/home")
    public String home() {
        return "home security";
    }

    @GetMapping("/contact-us")
    public String contactUs() {
        return "contact us security";
    }

    @GetMapping("/transfer")
    public String transfer() {
        return "transfer security";
    }

    @GetMapping("/get-balance")
    @PreAuthorize("hasRole('ADMIN')")
    public String getBalance() {
        return "get balance security";
    }
}
