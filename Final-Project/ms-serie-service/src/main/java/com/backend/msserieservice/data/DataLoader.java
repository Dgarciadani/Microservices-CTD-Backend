package com.backend.msserieservice.data;

import com.backend.msserieservice.domain.Chapter;
import com.backend.msserieservice.domain.Season;
import com.backend.msserieservice.domain.Series;
import com.backend.msserieservice.repository.IChapterRepository;
import com.backend.msserieservice.repository.ISeasonRepository;
import com.backend.msserieservice.repository.ISeriesRepository;
import com.backend.msserieservice.service.IChapterService;
import com.backend.msserieservice.service.ISeasonService;
import com.backend.msserieservice.service.ISeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final ISeriesRepository seriesService;
    private final ISeasonRepository seasonService;
    private final IChapterRepository chapterService;
    private final MongoTemplate mongoT;

    @Override

    public void run(ApplicationArguments args) throws Exception {
        mongoT.dropCollection("chapters");
        mongoT.dropCollection("seasons");
        mongoT.dropCollection("series");

        Series series = new Series();
        series.setName("serieChula");
        series.setGenre("Terror");
        Series savedSeries = seriesService.save(series);

        log.info("savedSeries: " + savedSeries);

        Season season = new Season();
        season.setSeasonNumber(1);
        season.setSeriesId(savedSeries.getId());
        Season savedSeason = seasonService.save(season);
        log.info("savedSeason: " + savedSeason);

        Chapter chapter = new Chapter();

        chapter.setName("Chapter 1");
        chapter.setChapterNumber(1);
        chapter.setUrlStream("https://www.youtube.com/watch?v=1");
        chapter.setSeasonId(savedSeason.getId());
        chapterService.save(chapter);
        log.info("savedChapter: " + chapter);


    }
}
