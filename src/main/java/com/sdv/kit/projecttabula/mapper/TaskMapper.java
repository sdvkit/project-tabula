package com.sdv.kit.projecttabula.mapper;

import com.sdv.kit.projecttabula.dto.TaskDto;
import com.sdv.kit.projecttabula.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}