package com.grego.msweatherservice.controller;

import com.grego.msweatherservice.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{city}/country/{country}")
    public Integer getTemperatureByCityAndCountry(@PathVariable String city, @PathVariable String country) {
        return weatherService.getTemperature(city, country);
    }
}
