package com.backend.msserieservice.service;

import com.backend.msserieservice.domain.Chapter;

import java.util.List;
import java.util.UUID;

public interface IChapterService {

    public Chapter save(Chapter chapter);
    public void saveAll(List<Chapter> chapters);
    public Chapter findByName(String name);
    public Chapter findById(String id);

    public List<Chapter> findBySeasonId(String id);
}
