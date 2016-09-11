package com.firstinnings.controllers;

import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Authentication controller that will handle the get and post methods of login page.
 * Created by poplig on 9/3/16.
 */
@Controller
public class AuthenticationController {

    /**
     * This method is responsible for authenticating the request.
     * @param name the user name entered
     * @param pass the password entered
     * @param request the http request
     * @param response the http response
     * @return the ModelAndView object
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ModelAndView authenticate(@RequestParam("username") String name, @RequestParam("password") String pass,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelMap = new ModelAndView();

        // Hard coding the values till we intergate with DB
        if ("gaurav".equals(name) && "gaurav".equals(pass)) {

            HttpSession httpSession =  request.getSession();
            httpSession.setAttribute("userId", "1");

            response.sendRedirect("/firstinnings/home");

        } else {

            // todo : handle invalid login in the login page.
            modelMap.addObject("status", "Invalid");
        }

        return modelMap;
    }

    /**
     * THis handles the render method of the login page
     * @param model the model containing the attributes for client side
     * @param request the http request
     * @param response the http response
     * @return the view to be rendered
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String render(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // see if we already authenticated.
        HttpSession httpSession1 = request.getSession();
        if(httpSession1.getAttribute("userId") != null) {
            response.sendRedirect("/firstinnings/home");
        }
        return "login";
    }


}
