package ar.edu.unju.fi.tpfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/forbidden")
    public String forbidden(){
        return "forbidden";
    }
}
