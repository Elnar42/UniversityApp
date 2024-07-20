package com.example.university.mappers;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.main_entities.Enrollment;
import org.mapstruct.Mapper;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")


public interface EnrollmentMapper extends MainMapper<EnrollmentDTO, Enrollment> {


}
