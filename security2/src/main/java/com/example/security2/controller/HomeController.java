package com.example.security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Home Page!";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome User!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome admin!";
    }


}
