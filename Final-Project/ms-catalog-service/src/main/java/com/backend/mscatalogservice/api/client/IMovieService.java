package com.backend.mscatalogservice.api.client;

import com.backend.mscatalogservice.configuration.CustomRandomLoadBalancer;
import com.backend.mscatalogservice.model.Movie;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
    @CircuitBreaker(name = "movie-service", fallbackMethod = "getMovieByGenreFallback")
   // @Bulkhead(name = "movie-service")
    @Retry(name = "movie-service")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable(value = "genre") String genre);

    default ResponseEntity<String> getMovieByGenreFallback(CallNotPermittedException e) {
        return ResponseEntity.ok().body("Movie Service is down");
    }
}
