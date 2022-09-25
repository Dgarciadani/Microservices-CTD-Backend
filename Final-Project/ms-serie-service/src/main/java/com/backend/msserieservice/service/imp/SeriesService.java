package com.backend.msserieservice.service.imp;

import com.backend.msserieservice.domain.Season;
import com.backend.msserieservice.domain.Series;
import com.backend.msserieservice.repository.ISeriesRepository;
import com.backend.msserieservice.service.IChapterService;
import com.backend.msserieservice.service.ISeasonService;
import com.backend.msserieservice.service.ISeriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class SeriesService implements ISeriesService {

    private final ISeriesRepository seriesRepository;


    private final ISeasonService seasonService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Series save(Series series) {
      Series savedSeries = seriesRepository.save(series);
      List<Season> seasons = series.getSeasons();
        if (series.getSeasons() != null) {
            seasons.forEach(s -> {
                s.setSeriesId(savedSeries.getId());
            });
            seasonService.saveAll(seasons);
            savedSeries.setSeasons(seasonService.findBySeriesId(savedSeries.getId()));
        }
        return savedSeries;

    }

    @Override
    public Series findByName(String name) {
        Series series = seriesRepository.findByName(name);
        List<Season> seasons = seasonService.findBySeriesId(series.getId());
        series.setSeasons(seasons);
        return series;
    }

    @Override
    public Series findById(String id) {
        return seriesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Series> findByGenre(String genre) {
        List<Series> series = seriesRepository.findByGenre(genre);
        series.forEach(s -> {
            List<Season> seasons = seasonService.findBySeriesId(s.getId());
            s.setSeasons(seasons);
        });
        log.info("series: {}", series);
        return series;
    }
}
