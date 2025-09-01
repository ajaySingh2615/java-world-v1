package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "index security";
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
}
