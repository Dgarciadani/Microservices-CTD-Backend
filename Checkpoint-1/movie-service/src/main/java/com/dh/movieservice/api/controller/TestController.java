package com.dh.movieservice.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${message}")
    private String message;

    private Environment environment;


    public TestController(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/message")
    ResponseEntity<String> getMessage() {
        return ResponseEntity.ok().body(this.message);
    }
}
