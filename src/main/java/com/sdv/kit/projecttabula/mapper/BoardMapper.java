package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.BoardDto;
import com.sdv.kit.projecttabula.model.Board;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoardMapper {

    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(source = "taskGroups", target = "taskGroupDtos")
    BoardDto toDto(Board board);

    Board fromDto(BoardDto boardDto);
}
