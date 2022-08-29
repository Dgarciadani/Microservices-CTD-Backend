package com.example.playlistservice.api.controller;

import com.example.playlistservice.api.client.MusicaServiceClient;
import com.example.playlistservice.domain.model.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaylistController {

	@Autowired
    MusicaServiceClient serviceClient;

	@GetMapping("/{genre}")
	ResponseEntity<List<Musica>> getGenre(@PathVariable String genre) {
		return serviceClient.getMovieByGenre(genre);
	}

}
