package com.dh.catalogservice.api.service;

import com.dh.catalogservice.api.client.MovieService;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CatalogService implements ICatalogService {

    @Autowired
    private MovieService movieService;

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        ResponseEntity<List<Movie>> response = movieService.getMovieByGenre(genre);
        return response.getBody();
    }
}
