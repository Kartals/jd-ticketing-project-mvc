package com.cybertek.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping({"/create","/add","/initialize"}) // we can define more than one endpoint in @getMapping. bu şu anlama gelmekte, tüm bu endpointler aynı html viewi vermektedir
    public String createUser(){

        return "user/create";
    }
}
