package com.example.university.service.app_service;

import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.main_entities.CourseSection;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class CourseSectionService extends MainService<CourseSectionDTO, Long, CourseSection> {
    public CourseSectionService(JpaRepositoryImplementation<CourseSection, Long> repository, MainMapper<CourseSectionDTO, CourseSection> mapper) {
        super(repository, mapper);
    }
}
