package com.sdv.kit.projecttabula.dto;

import java.time.LocalDateTime;

public record PersonDto(String name,
                        LocalDateTime createdAt,
                        String email,
                        String password) { }
