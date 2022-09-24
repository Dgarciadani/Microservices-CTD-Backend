package com.backend.msserieservice.repository;

import com.backend.msserieservice.domain.Series;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ISeriesRepository extends MongoRepository<Series, String> {

    public Series findByName(String name);

}
