package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.main_entities.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")


public interface SchoolMapper extends MainMapper<SchoolDTO, School> {


    @Mapping(source = "university.id", target = "university_id")
    SchoolDTO toDto(School school);

    @Mapping(target = "staff", ignore = true)
    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    @Mapping(source = "university_id", target = "university.id")
    School toEntity(SchoolDTO schoolDTO);

}
