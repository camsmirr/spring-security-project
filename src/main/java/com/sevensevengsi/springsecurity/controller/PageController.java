package com.sevensevengsi.springsecurity.controller;

import com.sevensevengsi.springsecurity.model.User;
import com.sevensevengsi.springsecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public String forAll(){
        return "forAll/page1";
    }

    @GetMapping("/form")
    public String UserForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", new User());
        return "customer_form";
    }
    @RequestMapping(value="/addUser_action", method=RequestMethod.POST)
    public String submitAddStaffForm( @ModelAttribute("user") User user, Model model) {
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/home";
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

