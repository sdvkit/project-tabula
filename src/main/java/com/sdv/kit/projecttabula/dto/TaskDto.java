package com.sdv.kit.projecttabula.dto;

import java.time.LocalDate;

public record TaskDto(Long id,
                      String title,
                      String description,
                      LocalDate creationDate,
                      LocalDate expirationDate) { }