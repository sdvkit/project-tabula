package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.PersonDto;
import com.sdv.kit.projecttabula.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto toDto(Person person);

    Person fromDto(PersonDto personDto);
}
