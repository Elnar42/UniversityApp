package com.example.university.service.app_service;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.main_entities.Student;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;


@Service
public class StudentService extends MainService<StudentDTO, Long, Student> {
    public StudentService(JpaRepositoryImplementation<Student, Long> repository, MainMapper<StudentDTO, Student> mapper) {
        super(repository, mapper);
    }
}
