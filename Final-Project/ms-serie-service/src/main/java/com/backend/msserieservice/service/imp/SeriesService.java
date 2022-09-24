package com.backend.msserieservice.service.imp;

import com.backend.msserieservice.domain.Season;
import com.backend.msserieservice.domain.Series;
import com.backend.msserieservice.repository.ISeriesRepository;
import com.backend.msserieservice.service.IChapterService;
import com.backend.msserieservice.service.ISeasonService;
import com.backend.msserieservice.service.ISeriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SeriesService implements ISeriesService {

    private final ISeriesRepository seriesRepository;


    private final ISeasonService seasonService;
    private final IChapterService chapterService;

    @Override
    public Series save(Series series) {
        return seriesRepository.save(series);
    }

    @Override
    public Series findByName(String name) {
        Series series = seriesRepository.findByName(name);
        List<Season> seasons = seasonService.findBySeriesId(series.getId());
        seasons.forEach(season -> {
            season.setChapters(chapterService.findBySeasonId(season.getId()));
        });
        series.setSeasons(seasons);
        return series;
    }

    @Override
    public Series findById(String id) {
        return seriesRepository.findById(id).orElse(null);
    }
}
