package com.example.university.repository;

import com.example.university.entity.main_entities.Program;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepositoryImplementation<Program, Long> {

}
