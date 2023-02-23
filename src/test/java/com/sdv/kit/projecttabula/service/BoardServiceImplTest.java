package com.sdv.kit.projecttabula.service;

import com.sdv.kit.projecttabula.dto.BoardDto;
import com.sdv.kit.projecttabula.model.Board;
import com.sdv.kit.projecttabula.model.Person;
import com.sdv.kit.projecttabula.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BoardServiceImplTest {

    @MockBean
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @Test
    void findByIdTest() {
        Board board = new Board(1L, "board1", Collections.emptyList(), Collections.emptySet(), new Person());
        when(boardRepository.findById(anyLong())).thenReturn(Optional.of(board));

        BoardDto actualBoardDto = boardService.findById(1L);
        assertEquals("board1", actualBoardDto.name());
        assertEquals(0, actualBoardDto.people().size());
        assertEquals(0, actualBoardDto.taskGroupDtos().size());
    }

    @Test
    void findAllByPersonEmailTest() {
        List<Board> boardList = List.of(
                new Board(1L, "board1", Collections.emptyList(), Collections.emptySet(), new Person()),
                new Board(2L, "board2", Collections.emptyList(), Collections.emptySet(), new Person()),
                new Board(3L, "board3", Collections.emptyList(), Collections.emptySet(), new Person()));
        when(boardRepository.findAllByPersonEmail(anyString())).thenReturn(boardList);

        List<BoardDto> boardDtos = boardService.findAllByPersonEmail("test@gmail.com");
        assertEquals(3, boardDtos.size());
    }
}
