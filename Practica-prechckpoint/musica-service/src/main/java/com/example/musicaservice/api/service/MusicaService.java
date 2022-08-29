package com.example.musicaservice.api.service;

import com.example.musicaservice.domain.model.Musica;
import com.example.musicaservice.domain.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

	@Autowired
	MusicaRepository repository;

	public List<Musica> findByGenre(String genre) {
		return repository.findByGenre(genre);
	}

	public Musica save(Musica musica) {
		return repository.save(musica);
	}
}
