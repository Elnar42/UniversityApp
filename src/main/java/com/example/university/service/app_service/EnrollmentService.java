package com.example.university.service.app_service;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.main_entities.Enrollment;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService extends MainService<EnrollmentDTO, Long, Enrollment> {


    public EnrollmentService(JpaRepositoryImplementation<Enrollment, Long> repository, MainMapper<EnrollmentDTO, Enrollment> mapper) {
        super(repository, mapper);
    }
}
