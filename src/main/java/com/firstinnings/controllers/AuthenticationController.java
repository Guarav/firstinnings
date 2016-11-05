package com.firstinnings.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.Constants;
import com.firstinnings.dto.Login;
import com.firstinnings.repositories.LoginRepository;

/**
 * Authentication controller that will handle the get and post methods of login page. Created by
 * poplig on 9/3/16.
 */
@Controller
public class AuthenticationController {

    private Map<String, String> userPassData = new HashMap<String, String>() {

        {
            put("Gaurav", "Popli");
            put("Rahul", "Kumar");
            put("Akshay", "Kumar");
            put("Manoj", "Popli");
        }
    };

    @Autowired
    private LoginRepository     loginRepository;

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

        Login login = loginRepository.findOne(name);
        // We don't need to store plain password (Once we will grow , we need to migrate all
        // password to it's hash).

        if (login != null && StringUtils.equals(pass, login.getPassword())) {

            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userId", "1");

            response.sendRedirect("/home");

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

        // Below line is just to have data into DB. Need to come up with plan location of DB. As
        // this comes when local server came up. At this time DB is empty.
        userPassData.forEach((username, password) -> loginRepository.save(new Login(username, password)));

        // see if we already authenticated.
        HttpSession httpSession1 = request.getSession();
        if (httpSession1.getAttribute("userId") != null) {
            response.sendRedirect(Constants.Pages.HOME);
        }
        return "login";
    }

}
