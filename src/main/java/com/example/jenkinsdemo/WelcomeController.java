package com.example.jenkinsdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hello")
public class WelcomeController {

    public ModelAndView welcome(){
        return new ModelAndView("login");
    }
}
