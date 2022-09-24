package com.backend.msserieservice.repository;

import com.backend.msserieservice.domain.Chapter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IChapterRepository extends MongoRepository<Chapter, String> {

        public Chapter findByName(String name);


        public List<Chapter> findChapterBySeasonId(String id);

}

