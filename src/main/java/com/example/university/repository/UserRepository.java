package com.example.university.repository;

import com.example.university.entity.auth_entities.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    Optional<User> findByEmail(String email);
}
