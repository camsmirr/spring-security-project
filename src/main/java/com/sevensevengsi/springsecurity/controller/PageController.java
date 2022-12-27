package com.sevensevengsi.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/all")
    public String forAll(){
        return "forAll/page1";
    }

    @GetMapping("/admin")
    public String forAdmin(){
        return "forAuthenticated/page2";
    }

    @GetMapping("/owner")
    public String forOwner(){
        return "forAuthenticated/page3";
    }

    @GetMapping("/manager")
    public String forManager(){
        return "forAuthenticated/page4";
    }

    @GetMapping("/customer")
    public String forCustomer(){
        return "forAuthenticated/page5";
    }

}

