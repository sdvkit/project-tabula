package com.sdv.kit.projecttabula.repository;

import com.sdv.kit.projecttabula.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByEmail(String email);
}