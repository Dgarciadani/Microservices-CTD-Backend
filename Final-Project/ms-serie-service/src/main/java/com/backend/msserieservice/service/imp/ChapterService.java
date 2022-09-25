package com.backend.msserieservice.service.imp;

import com.backend.msserieservice.domain.Chapter;
import com.backend.msserieservice.repository.IChapterRepository;
import com.backend.msserieservice.service.IChapterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.color.ICC_ColorSpace;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ChapterService implements IChapterService {

    private final IChapterRepository chapterRepository;


    @Override
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public void saveAll(List<Chapter> chapters) {
        chapterRepository.saveAll(chapters);
    }

    @Override
    public Chapter findByName(String name) {
        return chapterRepository.findByName(name);
    }

    @Override
    public Chapter findById(String id) {
        return chapterRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chapter> findBySeasonId(String id) {
        return chapterRepository.findChapterBySeasonId(id);
    }
}
