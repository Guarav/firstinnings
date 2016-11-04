package com.firstinnings.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.repositories.MemberRepository;

/**
 * This controller handles the addition of member task.
 */
@Controller
public class AddMemberController {

    @Autowired
    private MemberRepository repository;

    /**
     * Add a member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/addAMember")
    public String addAMember(ModelMap model) {

        return "AddMember";
    }

    /**
     * Add a member submit.
     * @param request
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addAMember")
    public ModelAndView addAMemberSubmit(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        Enumeration<String> list = request.getParameterNames();
        Map<String, String> allParameterDetails = new HashMap<>();
        while (list.hasMoreElements()) {
            String param = list.nextElement();
            allParameterDetails.put(param, request.getParameter(param));
        }
        System.out.println("add a member " + allParameterDetails);
        try {
            repository.save(new Member(allParameterDetails));
            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
            modelAndView.setViewName("home");
        } catch (Exception e) {
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));
            modelAndView.setViewName("AddMember");
        }

        return modelAndView;
    }

}