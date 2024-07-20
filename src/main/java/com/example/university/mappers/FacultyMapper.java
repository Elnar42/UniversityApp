package com.example.university.mappers;

import com.example.university.dto.FacultyDTO;
import com.example.university.entity.main_entities.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultyMapper extends MainMapper<FacultyDTO, Faculty> {

    @Mapping(source = "school.id", target = "school_id")
    FacultyDTO toDto(Faculty faculty);

    @Mapping(source = "school_id", target = "school.id")
    Faculty toEntity(FacultyDTO facultyDTO);
}
