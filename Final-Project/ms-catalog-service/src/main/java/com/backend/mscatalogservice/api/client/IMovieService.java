package com.backend.mscatalogservice.api.client;

import com.backend.mscatalogservice.configuration.CustomRandomLoadBalancer;
import com.backend.mscatalogservice.model.Movie;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "movie-service")
@LoadBalancerClient(name = "movie-service", configuration = CustomRandomLoadBalancer.class)
public interface IMovieService {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable(value = "genre") String genre);
}
