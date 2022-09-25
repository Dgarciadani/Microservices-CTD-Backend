package com.backend.msserieservice.service;

import com.backend.msserieservice.domain.Series;

import java.util.List;
import java.util.UUID;

public interface ISeriesService {

    public Series save(Series series);
    public Series findByName(String name);
    public Series findById(String id);

    public List<Series> findByGenre(String genre);
}
