package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enrollment extends MainEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSection;

    private LocalDateTime enrolledTime;


}
