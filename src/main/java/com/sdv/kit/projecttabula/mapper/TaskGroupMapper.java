package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.TaskGroupDto;
import com.sdv.kit.projecttabula.model.TaskGroup;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskGroupMapper {

    TaskGroupMapper INSTANCE = Mappers.getMapper(TaskGroupMapper.class);

    TaskGroup fromDto(TaskGroupDto taskGroupDto);

    TaskGroupDto toDto(TaskGroup taskGroup);
}