package com.example.university.mappers;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.main_entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")

public interface StudentMapper extends MainMapper<StudentDTO, Student> {

    @Mapping(target = "program_id", source = "program.id")
    StudentDTO toDto(Student student);

    @Mapping(target = "program.id", source = "program_id")
    @Mapping(target = "enrollments", ignore = true)
    Student toEntity(StudentDTO studentDTO);

}
