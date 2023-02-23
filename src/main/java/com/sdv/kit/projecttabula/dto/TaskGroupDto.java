package com.sdv.kit.projecttabula.dto;

import java.util.Set;

public record TaskGroupDto(Long id,
                           String name,
                           Set<TaskDto> tasks) { }