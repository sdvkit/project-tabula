package com.sdv.kit.projecttabula.service.impl;

import com.sdv.kit.projecttabula.repository.TaskRepository;
import com.sdv.kit.projecttabula.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
}
