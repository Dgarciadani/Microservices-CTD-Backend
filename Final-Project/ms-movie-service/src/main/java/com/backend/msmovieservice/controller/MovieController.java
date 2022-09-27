package com.backend.msmovieservice.controller;

import com.backend.msmovieservice.domain.Movie;
import com.backend.msmovieservice.domain.dto.MovieReceivedDto;
import com.backend.msmovieservice.domain.dto.MovieToSendDto;
import com.backend.msmovieservice.service.IMovieService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class MovieController {

    private final IMovieService service;


    @GetMapping("/{genre}")
    ResponseEntity<List<MovieToSendDto>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.getMovieByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<MovieToSendDto> saveMovie(@RequestBody MovieReceivedDto movie) {
        log.info("Movie received: {}", movie);
        return ResponseEntity.ok().body(service.save(movie));
    }
}
