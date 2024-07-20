package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends MainEntity {

    private String name;

    private String dean;

    private LocalDate establishmentDate;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "school")
    private List<Program> programs;

    @OneToMany(mappedBy = "school")
    private List<Faculty> faculty;

    @OneToMany(mappedBy = "school")
    private List<Staff> staff;


}
