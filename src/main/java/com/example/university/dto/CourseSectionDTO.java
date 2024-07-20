package com.example.university.dto;

import com.example.university.entity.main_entities.Course;
import com.example.university.entity.main_entities.Enrollment;
import com.example.university.entity.main_entities.SectionSchedule;
import com.example.university.enums.Semester;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CourseSectionDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private Semester semester;

    @Min(value = 10, message = "Min value for course capacity can be 10.")
    @Max(value = 40, message = "Max value for course capacity cab be 40.")
    private int capacity;

    @Null
    private Course mainCourse;

    @Null
    private List<Enrollment> enrollments;

    @Null
    private List<SectionSchedule> sectionSchedules;

}
