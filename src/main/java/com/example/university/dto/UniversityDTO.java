package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UniversityDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String rector;

    @NotBlank
    private String gradingSystem;

    @NotNull
    @Past
    private LocalDate establishment;

}
