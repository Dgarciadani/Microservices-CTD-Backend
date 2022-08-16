package com.grego.mscourseservice.service;

import com.grego.mscourseservice.domain.Course;
import com.grego.mscourseservice.repository.CourseRepository;
import com.grego.mscourseservice.repository.feing.ISubscription;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService implements CrudService<Course> {

    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Course> findAll() {
        return null;
    }

    @Override
    public void delete(Course course) {

    }
}


