package com.grego.mscourseservice.service;

import com.grego.mscourseservice.domain.Chapter;
import com.grego.mscourseservice.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChapterService implements CrudService<Chapter> {

    private final ChapterRepository chapterRepository;

    @Override
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    public Chapter findById(Long id) {
        return null;
    }

    @Override
    public Iterable<Chapter> findAll() {
        return null;
    }

    @Override
    public void delete(Chapter chapter) {

    }
}


