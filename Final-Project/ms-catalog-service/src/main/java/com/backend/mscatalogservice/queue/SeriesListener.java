package com.backend.mscatalogservice.queue;

import com.backend.mscatalogservice.api.service.ICatalogService;
import com.backend.mscatalogservice.model.series.Series;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SeriesListener {

    private final ICatalogService service;

    @RabbitListener(queues = "${queue.series.name}")
    public void listen(Series series) {
        log.info("Received: " + series);
        log.info("Genre: " + series.genre());
        service.addSeries(series.genre(),series);
    }

}
