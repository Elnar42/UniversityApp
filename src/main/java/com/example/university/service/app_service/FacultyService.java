package com.example.university.service.app_service;

import com.example.university.dto.FacultyDTO;
import com.example.university.entity.main_entities.Faculty;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class FacultyService extends MainService<FacultyDTO, Long, Faculty> {


    public FacultyService(JpaRepositoryImplementation<Faculty, Long> repository, MainMapper<FacultyDTO, Faculty> mapper) {
        super(repository, mapper);
    }
}
