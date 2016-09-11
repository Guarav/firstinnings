package com.firstinnings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String render(ModelMap model) {

        // todo : add calls to get the operatiosn/ actions that are possible
        return "home";
    }

}
