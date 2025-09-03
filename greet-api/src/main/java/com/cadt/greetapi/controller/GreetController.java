package com.cadt.greetapi.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class GreetController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(GreetController.class);

    @GetMapping("/greet")
    public String greet() {
        logger.info("Greet endpoint was called");
        return "Hello, Welcome to CADT!";
    }

}
