package com.example.university.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProgramDTO {

    @Null
    private Long id;

    @NotBlank
    private String name;

    @Positive
    @NotNull
    private Long school_id;


}
