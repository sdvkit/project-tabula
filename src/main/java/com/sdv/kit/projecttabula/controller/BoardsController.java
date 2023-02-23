package com.sdv.kit.projecttabula.controller;

import com.sdv.kit.projecttabula.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardsController {

    private final BoardService boardService;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String getAllBoards(Principal principal,
                               Model model) {
        model.addAttribute("boards", boardService.findAllByPersonEmail(
                (principal instanceof OAuth2AuthenticationToken)
                        ? ((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("email")
                        : principal.getName()));
        return "home-page";
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getBoardPage(@PathVariable("id") Long id,
                               Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board-page";
    }
}
