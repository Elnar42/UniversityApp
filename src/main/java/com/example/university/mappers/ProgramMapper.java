package com.example.university.mappers;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.main_entities.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")
public interface ProgramMapper extends MainMapper<ProgramDTO, Program> {

    @Mapping(target = "school_id", source = "school.id")
    ProgramDTO toDto(Program program);

    @Mapping(target = "students", ignore = true)
    @Mapping(target = "courses", ignore = true)
    @Mapping(source = "school_id", target = "school.id")
    Program toEntity(ProgramDTO programDTO);


}
