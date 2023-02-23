package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.PersonDto;
import com.sdv.kit.projecttabula.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Test
    void toDtoTest() {
        Person person = new Person(1L, "testperson", "testmail@gmail.com", "testpass", LocalDateTime.now(), Collections.emptyList(), Collections.emptyList());
        PersonDto personDto = PersonMapper.INSTANCE.toDto(person);

        assertEquals(person.getName(), personDto.name());
        assertEquals(person.getEmail(), personDto.email());
        assertEquals(person.getPassword(), personDto.password());
        assertEquals(person.getCreatedAt(), personDto.createdAt());
    }

    @Test
    void fromDtoTest() {
        PersonDto personDto = new PersonDto("testperson", LocalDateTime.now(), "testmail@gmail.com", "testpass");
        Person person = PersonMapper.INSTANCE.fromDto(personDto);

        assertEquals(personDto.name(), person.getName());
        assertEquals(personDto.email(), person.getEmail());
        assertEquals(personDto.password(), person.getPassword());
        assertEquals(personDto.createdAt(), person.getCreatedAt());
    }
}
