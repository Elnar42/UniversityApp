package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends MainEntity {

    @OneToMany(mappedBy = "university")
    private List<School> schools;

    @OneToMany
    private List<Staff> staff;

    private String name;
    private String location;
    private LocalDate establishment;
    private String rector;
    private String gradingSystem;

}
