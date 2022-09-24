package com.backend.msserieservice.controller;

import com.backend.msserieservice.domain.Series;
import com.backend.msserieservice.service.ISeriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class SeriesController {

    private final ISeriesService seriesService;

    @PostMapping("/register")
    public ResponseEntity<Series> register(@RequestBody Series series) {
        return ResponseEntity.ok(seriesService.save(series));
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<Series> findByName(@PathVariable String name) {
        return ResponseEntity.ok(seriesService.findByName(name));
    }


}
