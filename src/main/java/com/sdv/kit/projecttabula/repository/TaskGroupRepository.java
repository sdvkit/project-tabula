package com.sdv.kit.projecttabula.repository;

import com.sdv.kit.projecttabula.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {
}