package com.example.university.mappers;

import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.main_entities.CourseSection;
import org.mapstruct.Mapper;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")

public interface CourseSectionMapper extends MainMapper<CourseSectionDTO, CourseSection> {


}
