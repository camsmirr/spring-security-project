package com.sevensevengsi.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/access_denied")
    public String denied(){
        return "access_denied";
    }
}