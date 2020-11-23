package com.cybertek.controller;


import com.cybertek.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // @GetMapping({"/create","/add","/initialize"}) --> we can define more than one endpoint in @GetMapping. bu şu anlama gelmekte, tüm bu endpointler aynı html viewi vermektedir
    @GetMapping("/create")
    public String createUser(Model model){

        model.addAttribute("user", new UserDTO());
        return "user/create";
    }
}
