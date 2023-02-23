package com.sdv.kit.projecttabula.service;

import com.sdv.kit.projecttabula.model.Person;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public interface PersonService {
    OidcUser authenticateOauthUser(OidcIdToken idToken);
}
