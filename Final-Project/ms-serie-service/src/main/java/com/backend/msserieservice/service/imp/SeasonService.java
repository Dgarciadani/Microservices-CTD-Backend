package com.backend.msserieservice.service.imp;

import com.backend.msserieservice.domain.Season;
import com.backend.msserieservice.repository.ISeasonRepository;
import com.backend.msserieservice.service.ISeasonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SeasonService implements ISeasonService {


    private final ISeasonRepository seasonRepository;

    @Override
    public Season save(Season season) {
        return seasonRepository.save(season);
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
        return seasonRepository.findBySeriesId(seriesId);
    }
}
