package com.example.university.service.app_service;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.main_entities.School;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class SchoolService extends MainService<SchoolDTO, Long, School> {
    public SchoolService(JpaRepositoryImplementation<School, Long> repository, MainMapper<SchoolDTO, School> mapper) {
        super(repository, mapper);
    }
}
