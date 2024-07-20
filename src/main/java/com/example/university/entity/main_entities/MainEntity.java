package com.example.university.entity.main_entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springdoc.core.converters.models.MonetaryAmount;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@MappedSuperclass  // FIXED
public abstract class MainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
