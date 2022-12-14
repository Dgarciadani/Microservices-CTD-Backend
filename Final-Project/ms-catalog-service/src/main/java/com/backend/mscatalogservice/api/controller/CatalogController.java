package com.backend.mscatalogservice.api.controller;


import com.backend.mscatalogservice.api.service.CatalogService;
import com.backend.mscatalogservice.model.Catalog;
import com.backend.mscatalogservice.model.Movie;
import com.backend.mscatalogservice.model.series.Series;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CatalogController {

    private final CatalogService service;


    @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {

        return ResponseEntity.ok().body(service.getMovieByGenre(genre));
    }
    @GetMapping("/series/{genre}")
    ResponseEntity<List<Series>> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.getSeriesByGenre(genre));
    }
    @GetMapping("/{genre}")
    ResponseEntity<Catalog> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.getCatalogByGenre(genre));
    }
}
