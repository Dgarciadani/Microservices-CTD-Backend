package com.backend.msserieservice.service.imp;

import com.backend.msserieservice.domain.Chapter;
import com.backend.msserieservice.domain.Season;
import com.backend.msserieservice.repository.ISeasonRepository;
import com.backend.msserieservice.service.IChapterService;
import com.backend.msserieservice.service.ISeasonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class SeasonService implements ISeasonService {


    private final ISeasonRepository seasonRepository;

    private final IChapterService chapterService;

    @Override
    public Season save(Season season) {
        Season savedSeason = seasonRepository.save(season);
        if (savedSeason.getChapters() != null) {
            log.info("Saving season chapters");
            log.info("Chapters: " + savedSeason.getChapters());
            List<Chapter> chapters = season.getChapters();
            chapters.forEach(chapter -> {
                chapter.setSeasonId(savedSeason.getId());
            });
            chapters.forEach(chapterService::save);
            savedSeason.setChapters(chapterService.findBySeasonId(savedSeason.getId()));
            log.info("savedSeason: " + savedSeason);
        }
        return savedSeason;
    }

    @Override
    public void saveAll(List<Season> seasons) {
        seasonRepository.saveAll(seasons);
    }

    @Override
    public Season findBySeasonNumber(Integer seasonNumber) {
        return seasonRepository.findBySeasonNumber(seasonNumber);
    }

    @Override
    public Season findById(String id) {
        return seasonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Season> findBySeriesId(String seriesId) {
        List<Season> seasons = seasonRepository.findBySeriesId(seriesId);
        seasons.forEach(season -> {
            season.setChapters(chapterService.findBySeasonId(season.getId()));
        });
        return seasons;

    }
}
