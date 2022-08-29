package com.example.playlistservice.api.client;

import com.example.playlistservice.domain.model.Musica;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name="musica-service")
public interface MusicaServiceClient {

	@GetMapping("/{genre}")
	ResponseEntity<List<Musica>> getMovieByGenre(@PathVariable (value = "genre") String genre);

}
