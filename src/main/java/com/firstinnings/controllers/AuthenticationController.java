package com.firstinnings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by poplig on 9/3/16.
 */
@Controller
public class AuthenticationController {

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ModelAndView authenticate(@RequestParam("username") String name, @RequestParam("password") String pass,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelMap = new ModelAndView();

        if ("gaurav".equals(name) && "gaurav".equals(pass)) {
            modelMap.addObject("status", "You are authenticated");
            response.sendRedirect("/firstinnings/home");

        } else {
            modelMap.addObject("status", "Invalid");
        }

        return modelMap;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String render(ModelMap model) {

        return "login";
    }


}
