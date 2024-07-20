package com.example.university.entity.main_entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course extends MainEntity {

    private String name;

    @Lob
    private String description;

    private boolean isActive;

    @OneToMany
    private List<Course> preRequisite;

    @OneToMany
    private List<Course> coreRequisite;


    @OneToMany(mappedBy = "course")
    private Set<CourseSection> courseSections;


    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

}
