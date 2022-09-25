package com.backend.msserieservice.controller;

import com.backend.msserieservice.domain.Series;
import com.backend.msserieservice.service.ISeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class SeriesController {

    private final ISeriesService seriesService;

    @PostMapping("/")
    public ResponseEntity<Series> register(@RequestBody Series series) {
        return ResponseEntity.ok(seriesService.save(series));
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<Series> findByName(@PathVariable String name) {
        return ResponseEntity.ok(seriesService.findByName(name));
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Series>> findByGenre(@PathVariable String genre) {
        log.info("Find by genre: " + genre);
        return ResponseEntity.ok(seriesService.findByGenre(genre));
    }

}
