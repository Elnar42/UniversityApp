package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FacultyDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    private Long school_id;

    @NotNull
    private int age;
}
