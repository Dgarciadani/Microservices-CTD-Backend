package com.example.musicaservice.domain.repository;

import com.example.musicaservice.domain.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

	@Query("SELECT m FROM Musica m WHERE m.genre = ?1")
	List<Musica> findByGenre(String genre);
}
