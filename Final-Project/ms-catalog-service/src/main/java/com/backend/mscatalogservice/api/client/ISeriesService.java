package com.backend.mscatalogservice.api.client;

import com.backend.mscatalogservice.model.series.Series;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "series-service")
public interface ISeriesService {

    @GetMapping("/series/{genre}")
    ResponseEntity<List<Series>> getSeriesByGenre(@PathVariable(value = "genre") String genre);

}
