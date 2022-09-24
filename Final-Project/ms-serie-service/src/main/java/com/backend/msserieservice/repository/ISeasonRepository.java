package com.backend.msserieservice.repository;

import com.backend.msserieservice.domain.Season;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ISeasonRepository extends MongoRepository<Season, String> {

    public Season findBySeasonNumber(Integer seasonNumber);

    public List<Season> findBySeriesId(String seriesId);
}

