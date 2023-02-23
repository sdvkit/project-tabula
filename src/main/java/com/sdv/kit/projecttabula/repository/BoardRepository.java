package com.sdv.kit.projecttabula.repository;

import com.sdv.kit.projecttabula.model.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b join fetch b.taskGroups tg join fetch b.people p join fetch b.creator c join fetch tg.tasks t where p.email = ?1")
    List<Board> findAllByPersonEmail(String email);

    @Override
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"taskGroups", "taskGroups.tasks"})
    Optional<Board> findById(Long id);
}