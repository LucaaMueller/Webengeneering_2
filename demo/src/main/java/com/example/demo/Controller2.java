package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/assets")
public class Controller2 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/health")
    public Map<String, Object> getHealth() {
        boolean databaseConnected;



        try (Connection connection = dataSource.getConnection()) {
            databaseConnected = (connection != null && !connection.isClosed());
        } catch (SQLException e) {
            databaseConnected = false;
        }



        return Map.of(
                "live", true,
                "ready", databaseConnected,
                "databases", Map.of(
                        "assets", Map.of("connected", databaseConnected)
                )
        );
    }
}
