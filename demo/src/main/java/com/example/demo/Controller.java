package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/assets")
public class Controller {

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return Map.of(
                "authors", List.of("Luca Mueller", "Jan Kaiser"),
                "api_version", "3.1.0"
        );
    }
}





