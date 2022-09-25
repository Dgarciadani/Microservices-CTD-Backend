package com.backend.msmovieservice.data;

import com.backend.msmovieservice.domain.Movie;
import com.backend.msmovieservice.repository.IMovieRepository;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class DataLoader implements ApplicationRunner {

    private final IMovieRepository repository;

    public DataLoader(IMovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.save(new Movie(UUID.randomUUID(), "filme", "terror", "what"));
        repository.save(new Movie(UUID.randomUUID(), "borboleta", "terror", "what"));
        repository.save(new Movie(UUID.randomUUID(), "adedonha", "terror", "what"));
        repository.save(new Movie(UUID.randomUUID(), "pajero", "terror", "what"));
        repository.save(new Movie(UUID.randomUUID(), "dakar", "acao", "what"));
        repository.save(new Movie(UUID.randomUUID(), "shadow", "acao", "what"));
        repository.save(new Movie(UUID.randomUUID(), "boné", "romance", "what"));
        repository.save(new Movie(UUID.randomUUID(), "xícara", "romance", "what"));
    }
}
