package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.BoardDto;
import com.sdv.kit.projecttabula.dto.PersonDto;
import com.sdv.kit.projecttabula.model.Board;
import com.sdv.kit.projecttabula.model.Person;
import com.sdv.kit.projecttabula.model.TaskGroup;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardMapperTest {

    @Test
    void toDtoTest() {
        Person creator = Person.builder()
                .name("testcreator1")
                .build();
        Board board = new Board(1L, "testboard1", List.of(new TaskGroup()), Set.of(creator), creator);
        BoardDto boardDto = BoardMapper.INSTANCE.toDto(board);

        assertEquals(board.getId(), boardDto.id());
        assertEquals(board.getName(),boardDto.name());
        assertEquals(board.getPeople().size(), boardDto.people().size());
        assertEquals(board.getCreator().getName(), boardDto.creator().name());
    }

    @Test
    void fromDtoTest() {
        PersonDto creator = new PersonDto("testcreator1", LocalDateTime.now(), "testmail@gmail.com", "testpass");
        BoardDto boardDto = new BoardDto(1L, "testboard1", Set.of(creator), creator, Collections.emptyList());
        Board board = BoardMapper.INSTANCE.fromDto(boardDto);

        assertEquals(boardDto.id(), board.getId());
        assertEquals(boardDto.name(), board.getName());
        assertEquals(boardDto.people().size(), board.getPeople().size());
        assertEquals(boardDto.creator().name(), board.getCreator().getName());
    }
}
