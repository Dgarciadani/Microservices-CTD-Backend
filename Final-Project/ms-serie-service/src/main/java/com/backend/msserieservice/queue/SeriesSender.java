package com.backend.msserieservice.queue;

import com.backend.msserieservice.domain.Series;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SeriesSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue seriesQueue;

    public void sendSeries(Series series) {
        //add header
        this.rabbitTemplate.convertAndSend(this.seriesQueue.getName(), series);
    }
}
