package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestControlller {

    @GetMapping("/")
    public String home() {
        return "Willkommen zur Startseite!";
    }
}
