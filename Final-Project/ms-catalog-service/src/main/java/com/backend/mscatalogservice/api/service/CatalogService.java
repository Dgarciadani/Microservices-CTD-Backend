package com.backend.mscatalogservice.api.service;

import com.backend.mscatalogservice.api.client.IMovieService;

import com.backend.mscatalogservice.api.client.ISeriesService;
import com.backend.mscatalogservice.model.Movie;
import com.backend.mscatalogservice.model.series.Series;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CatalogService implements ICatalogService {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ISeriesService seriesService;

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        ResponseEntity<List<Movie>> response = movieService.getMovieByGenre(genre);
        return response.getBody();
    }

    @Override
    public List<Series> getSeriesByGenre(String genre) {
        ResponseEntity<List<Series>> response = seriesService.getSeriesByGenre(genre);
        log.info("response: {}", response);
        return response.getBody();
    }

}
