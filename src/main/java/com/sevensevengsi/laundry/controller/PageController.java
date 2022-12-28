package com.sevensevengsi.laundry.controller;

import com.sevensevengsi.laundry.model.MachineStatus;
import com.sevensevengsi.laundry.repository.MachineRepository;
import com.sevensevengsi.laundry.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import com.sevensevengsi.laundry.model.User;
import com.sevensevengsi.laundry.repository.UserRepository;
import java.util.List;


@Controller
    @RequestMapping("/page")
    public class PageController {

        @Autowired
        UserRepository userRepository;
        @Autowired
        UserDetailsService userDetailsService;
        @Autowired
        private MachineRepository machineRepository;

    @GetMapping("/user_form")
    public String showUserAddForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "customer_form";
    }
//
//    @PostMapping("/user_addAction")
//    public String submitTournamentAddForm(@ModelAttribute("user") User user, ModelMap model){
//        System.out.print(user.)
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword;
//        encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//        return "redirect:/listOfUsers";
//    }

    @PostMapping("/user_addAction")
    public String submitAddStaffForm(@ModelAttribute("user") User user, ModelMap model) {
        System.out.println(user.getPassword() + "Hi");
        System.out.println(user.getEmail() + "Hi");
        System.out.println(user.getName() + "Hi");
        System.out.println(user.getRole() + "Hello");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword;
        encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/page/admin/listOfUsers";
    }

        @RequestMapping(value = "/admin/listOfUsers")
        public String listOfUsers( @ModelAttribute("listOfUsers") User user, BindingResult result, Model model) {
            List<User> listOfUsers = userRepository.findAll();
            model.addAttribute("listOfUsers", listOfUsers);
            return "listOfUsers";
        }

    @RequestMapping(value = "/owner/listOfMachines")
    public String listOfMachines(@ModelAttribute("listOfMachines")MachineStatus machine, Model model) {
        List<MachineStatus> listOfMachines = machineRepository.findAll();
        model.addAttribute("listOfMachines", listOfMachines);
        return "listOfMachines";
    }
}

