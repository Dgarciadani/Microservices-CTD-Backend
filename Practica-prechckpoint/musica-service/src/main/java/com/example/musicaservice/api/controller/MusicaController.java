package com.example.musicaservice.api.controller;

import com.example.musicaservice.api.service.MusicaService;
import com.example.musicaservice.domain.model.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
public class MusicaController {

	@Autowired
	MusicaService service;

	@GetMapping("/{genre}")
	ResponseEntity<List<Musica>> getMusicaByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(service.findByGenre(genre));
	}

	@PostMapping("/salvar")
	ResponseEntity<Musica> saveMusica(@RequestBody Musica musica) {
		return ResponseEntity.ok().body(service.save(musica));
	}
}
