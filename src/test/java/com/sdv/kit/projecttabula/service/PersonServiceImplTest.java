package com.sdv.kit.projecttabula.service;

import com.sdv.kit.projecttabula.model.Person;
import com.sdv.kit.projecttabula.repository.PersonRepository;
import com.sdv.kit.projecttabula.service.impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImplTest {

    @MockBean
    private final PersonRepository personRepository;
    private final PersonServiceImpl personServiceImpl;

    @Test
    void loadUserByUsernameTest() {
        Person person = new Person(1L, "Ivan Ivanov", "testmail@gmail.com", "pass123", LocalDateTime.now(), Collections.emptyList(), Collections.emptyList());
        when(personRepository.findPersonByEmail(anyString())).thenReturn(Optional.of(person));

        UserDetails personDetails = personServiceImpl.loadUserByUsername("testmail@gmail.com");
        assertEquals("testmail@gmail.com",personDetails.getUsername());
        assertEquals("pass123", personDetails.getPassword());
        assertTrue(personDetails.isAccountNonLocked());
        assertTrue(personDetails.isCredentialsNonExpired());
        assertTrue(personDetails.isEnabled());
        assertTrue(personDetails.isAccountNonExpired());
    }
}
