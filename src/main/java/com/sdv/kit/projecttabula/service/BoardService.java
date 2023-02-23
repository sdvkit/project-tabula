package com.sdv.kit.projecttabula.service;

import com.sdv.kit.projecttabula.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> findAllByPersonEmail(String email);

    BoardDto findById(Long id);
}
