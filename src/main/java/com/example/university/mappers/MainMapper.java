package com.example.university.mappers;

import com.example.university.entity.main_entities.MainEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

//@Mapper(config = CentralConfig.class)
@MapperConfig
public interface MainMapper<D, M extends MainEntity> {

    D toDto(M entity);

    M toEntity(D dto);

    @Mapping(target = "id", ignore = true)
    M toEntity(@MappingTarget M entity, D dto);
}
