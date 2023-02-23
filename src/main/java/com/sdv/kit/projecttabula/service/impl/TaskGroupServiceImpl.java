package com.sdv.kit.projecttabula.service.impl;

import com.sdv.kit.projecttabula.repository.TaskGroupRepository;
import com.sdv.kit.projecttabula.service.TaskGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskGroupServiceImpl implements TaskGroupService {

    private final TaskGroupRepository taskGroupRepository;
}
