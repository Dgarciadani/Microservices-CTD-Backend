package com.backend.msmovieservice.repository;

import com.backend.msmovieservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IMovieRepository extends JpaRepository<Movie, UUID> {
}
