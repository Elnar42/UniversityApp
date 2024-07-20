package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Program extends MainEntity {

    private String name;

    @OneToMany(mappedBy = "program")
    private List<Course> courses;

    @OneToMany(mappedBy = "program")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;


}
