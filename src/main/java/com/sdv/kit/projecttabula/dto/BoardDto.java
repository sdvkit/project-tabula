package com.sdv.kit.projecttabula.dto;

import java.util.List;
import java.util.Set;

public record BoardDto(Long id,
                       String name,
                       Set<PersonDto> people,
                       PersonDto creator,
                       List<TaskGroupDto> taskGroupDtos) { }