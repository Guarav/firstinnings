package com.firstinnings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

/**
 * Created by poplig on 9/3/16.
 */
@Controller
@RequestMapping("/login")
public class AuthenticationController {
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView authenticate(@RequestParam("name")String name, @RequestParam("password") String pass) {

        ModelAndView modelMap = new ModelAndView();

        modelMap.setViewName("hello");


        if("gaurav".equals(name) && "gaurav".equals(pass)) {
            modelMap.addObject("status", "You are authenticated");
        } else {
            modelMap.addObject("status", "Invalid");
        }



        return modelMap;
    }
}
