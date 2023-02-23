package com.sdv.kit.projecttabula.controller;

import com.sdv.kit.projecttabula.model.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    @GetMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public String getLoginPage(@ModelAttribute("person") Person person) {
        return "auth/login-page";
    }
}
