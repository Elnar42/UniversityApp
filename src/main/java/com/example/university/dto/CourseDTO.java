package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
public class CourseDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Length(max = 1000)
    private String description;

    private boolean isActive;

    @Positive
    @NotNull
    private Long program_id;

}
