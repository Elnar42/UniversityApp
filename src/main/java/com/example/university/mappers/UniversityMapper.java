package com.example.university.mappers;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.main_entities.University;
import org.mapstruct.Mapper;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")
public interface UniversityMapper extends MainMapper<UniversityDTO, University> {

}
