package com.backend.msserieservice.service;

import com.backend.msserieservice.domain.Season;

import java.util.List;
import java.util.UUID;

public interface ISeasonService {

    public Season save(Season season);
    public Season findBySeasonNumber(Integer seasonNumber);
    public Season findById(String id);

    public List<Season> findBySeriesId(String seriesId);
}
