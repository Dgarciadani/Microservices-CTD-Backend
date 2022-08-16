package com.grego.mscourseservice.repository;

import com.grego.mscourseservice.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Course findCourseById(Long id);

}

