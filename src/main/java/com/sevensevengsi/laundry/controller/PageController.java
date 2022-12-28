package com.sevensevengsi.laundry.controller;

import com.sevensevengsi.laundry.model.MachineStatus;
import com.sevensevengsi.laundry.repository.MachineRepository;
import com.sevensevengsi.laundry.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import com.sevensevengsi.laundry.model.User;
import com.sevensevengsi.laundry.repository.UserRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
    @RequestMapping("/page")
    public class PageController {

        @Autowired
        UserRepository userRepository;

        @Autowired
        UserDetailsService userDetailsService;
    @Autowired
    private MachineRepository machineRepository;

    @GetMapping("/form")
        public String getUserForm(Model model) {
            model.addAttribute("user", new User());
            return "customer_form";
        }

        @PostMapping("/userAction")
        public String submitAddStaffForm(User user){
            userDetailsService.saveUser(user);
            return "redirect:/home";
        }

        @RequestMapping(value = "/admin/listOfUsers")
        public String listOfUsers( @ModelAttribute("listOfUsers") User user, BindingResult result, Model model) {
            List<User> listOfUsers = userRepository.findAll();
            model.addAttribute("listOfUsers", listOfUsers);
            return "listOfUsers";
        }

    @RequestMapping(value = "/manager/listOfMachines")
    public String listOfMachines(@ModelAttribute("listOfMachines")MachineStatus machine, Model model) {
        List<MachineStatus> listOfMachines = machineRepository.findAll();
        model.addAttribute("listOfMachines", listOfMachines);
        return "listOfMachines";
    }
}

