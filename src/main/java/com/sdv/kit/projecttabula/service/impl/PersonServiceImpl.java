package com.sdv.kit.projecttabula.service.impl;

import com.sdv.kit.projecttabula.model.Person;
import com.sdv.kit.projecttabula.repository.PersonRepository;
import com.sdv.kit.projecttabula.security.PersonDetails;
import com.sdv.kit.projecttabula.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService, UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findPersonByEmail(username)
                .map(PersonDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Person with this Username isn't found "));
    }

    @Transactional
    @Override
    public OidcUser authenticateOauthUser(OidcIdToken idToken) {
        personRepository.findPersonByEmail(idToken.getEmail())
                .orElseGet(() -> personRepository.save(Person.builder()
                        .createdAt(LocalDateTime.now())
                        .email(idToken.getEmail())
                        .name(idToken.getFullName())
                        .build()));
        return new DefaultOidcUser(null, idToken);
    }
}
