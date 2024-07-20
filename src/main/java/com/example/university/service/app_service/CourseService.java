package com.example.university.service.app_service;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.main_entities.Course;
import com.example.university.mappers.MainMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
@CacheConfig()
@Service
public class CourseService extends MainService<CourseDTO, Long, Course> {

    public CourseService(JpaRepositoryImplementation<Course, Long> repository, MainMapper<CourseDTO, Course> mapper) {
        super(repository, mapper);
    }
}
