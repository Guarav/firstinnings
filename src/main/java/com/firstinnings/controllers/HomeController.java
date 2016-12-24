package com.firstinnings.controllers;

import com.firstinnings.dto.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This controller is responsible for rendering the home page.
 * Created by poplig on 9/7/16.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * Render home page.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView render(ModelMap model) {

        // todo : move this data source to get the list of roles available to a particular login.

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        List<Role> roles = Arrays.asList(
                new Role("enquiry", "Enquiry"),
                new Role("defaulters", "Defaulters"),
                new Role("addAMember", "Add a member"),
                new Role("updateMember", "Update member details"),
                new Role("subscribeMember", "Add Subscription"),
                new Role("getRevenue", "Get Revenue")
        );

        modelAndView.addObject("roles", roles);

        return modelAndView;
    }

}
