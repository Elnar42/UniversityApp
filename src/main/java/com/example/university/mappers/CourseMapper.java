package com.example.university.mappers;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.main_entities.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper extends MainMapper<CourseDTO, Course> {


    @Mapping(target = "program_id", source = "program.id")
    CourseDTO toDto(Course course);


    @Mapping(target = "program.id", source = "program_id")
    @Mapping(target = "preRequisite", ignore = true)
    @Mapping(target = "courseSections", ignore = true)
    @Mapping(target = "coreRequisite", ignore = true)
    Course toEntity(CourseDTO courseDTO);
}
