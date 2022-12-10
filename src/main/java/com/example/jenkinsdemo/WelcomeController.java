package com.example.jenkinsdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public ModelAndView welcome(){
        return new ModelAndView("login");
    }
}
