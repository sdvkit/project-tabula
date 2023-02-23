package com.sdv.kit.projecttabula.repository;

import com.sdv.kit.projecttabula.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}