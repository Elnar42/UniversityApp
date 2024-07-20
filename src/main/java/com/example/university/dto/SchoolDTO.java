package com.example.university.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Getter
@Setter
public class SchoolDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String dean;

    @Nullable
    private LocalDate establishmentDate;

    @Positive
    @NotNull
    private Long university_id;

}
