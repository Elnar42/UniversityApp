package com.example.university.repository;

import com.example.university.entity.main_entities.Faculty;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepositoryImplementation<Faculty, Long> {
}
