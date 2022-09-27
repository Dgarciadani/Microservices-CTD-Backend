package com.backend.mscatalogservice.queue;

import com.backend.mscatalogservice.api.service.ICatalogService;
import com.backend.mscatalogservice.model.Movie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class MovieListener {

    private final ICatalogService service;

    @RabbitListener(queues = "${queue.movie.name}")
    public void listen(Movie movie) {
        log.info("Received: " + movie);
        //get genre from the record
       log.info("Genre: " + movie.genre());
        service.addMovie(movie.genre(),movie);

    }

}
