package com.backend.msmovieservice.controller;

import com.backend.msmovieservice.domain.Movie;
import com.backend.msmovieservice.domain.dto.MovieReceivedDto;
import com.backend.msmovieservice.domain.dto.MovieToSendDto;
import com.backend.msmovieservice.service.IMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final IMovieService service;

    @Autowired
    private Environment environment;


    public MovieController(IMovieService service) {
        this.service = service;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<MovieToSendDto>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().header("port",environment.getProperty("server.port")).body(service.getMovieByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<MovieToSendDto> saveMovie(@RequestBody MovieReceivedDto movie) {
        return ResponseEntity.ok().body(service.save(movie));
    }
}
