package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.PersonDto;
import com.sdv.kit.projecttabula.model.Person;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-26T14:47:48+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        String name = null;
        LocalDateTime createdAt = null;
        String email = null;
        String password = null;

        name = person.getName();
        createdAt = person.getCreatedAt();
        email = person.getEmail();
        password = person.getPassword();

        PersonDto personDto = new PersonDto( name, createdAt, email, password );

        return personDto;
    }

    @Override
    public Person fromDto(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.name( personDto.name() );
        person.email( personDto.email() );
        person.password( personDto.password() );
        person.createdAt( personDto.createdAt() );

        return person.build();
    }
}
