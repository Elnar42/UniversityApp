package com.example.university.entity.main_entities;

import com.example.university.enums.Semester;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseSection extends MainEntity {

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Faculty> professor;

    @OneToMany(mappedBy = "courseSection")
    private List<Enrollment> enrollments = new LinkedList<>();

    @OneToMany(mappedBy = "courseSection")
    private List<SectionSchedule> sectionSchedules = new LinkedList<>();

    private int capacity;

    private Semester semester;

}
