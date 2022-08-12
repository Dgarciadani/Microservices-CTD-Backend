package com.grego.msimagesservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    private Environment env;

    public ImageController(Environment env) {
        this.env = env;
    }

    @GetMapping("/image/{image}")
    public String getUrlImage(@PathVariable  String image) {
        String url = env.getProperty("image.url");
        return url + image;
    }
}
