package com.example.musicaservice.domain.data;

import com.example.musicaservice.domain.model.Musica;
import com.example.musicaservice.domain.repository.MusicaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

	private MusicaRepository repository;

	public DataLoader (MusicaRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run (ApplicationArguments args) throws Exception {
		repository.save(new Musica(1L, "Djavan", "MPB", "what"));
		repository.save(new Musica(2L, "Kevinho", "Funk", "what"));
		repository.save(new Musica(3L, "Slipknot", "Rock", "what"));
		repository.save(new Musica(4L, "Anitta", "Pop", "what"));
		repository.save(new Musica(5L, "Djonga", "Hip Hop", "what"));
		repository.save(new Musica(6L, "MD Chefe", "Trap", "what"));
		repository.save(new Musica(7L, "Alok", "Eletronica", "what"));
		repository.save(new Musica(8L, "Ivete Sangalo", "Axé", "what"));
	}
}
