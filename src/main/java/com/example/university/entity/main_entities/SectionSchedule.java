package com.example.university.entity.main_entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

//TODO Replace with List<List<...Date>>
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SectionSchedule extends MainEntity {


    @ManyToOne
    @JoinColumn(name = "section_id")
    private CourseSection courseSection;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;


    private LocalTime startTime;
    private Duration duration;
    private LocalTime endTime;

}
