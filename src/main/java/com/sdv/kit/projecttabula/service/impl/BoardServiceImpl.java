package com.sdv.kit.projecttabula.service.impl;

import com.sdv.kit.projecttabula.dto.BoardDto;
import com.sdv.kit.projecttabula.mapper.BoardMapper;
import com.sdv.kit.projecttabula.repository.BoardRepository;
import com.sdv.kit.projecttabula.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> findAllByPersonEmail(String email) {
        return boardRepository.findAllByPersonEmail(email)
                .stream().map(BoardMapper.INSTANCE::toDto)
                .toList();
    }

    @Override
    @Cacheable(value = "boards")
    public BoardDto findById(Long id) {
        return boardRepository.findById(id)
                .map(BoardMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
