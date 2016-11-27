package com.firstinnings.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.firstinnings.dto.Enquiry;
import com.firstinnings.dto.Subscription;
import com.firstinnings.repositories.EnquiryRepository;
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
public class EnquiryController {

    @Autowired
    private EnquiryRepository repository;

    /**
     * Add a member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/Enquiry")
    public String addAMember(ModelMap model) {

        return "Enquiry";
    }

    /**
     * Add a member submit.
     * @param request
     */
    @RequestMapping(method = RequestMethod.POST, value = "/Enquiry")
    public ModelAndView addAMemberSubmit(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        Enumeration<String> list = request.getParameterNames();
        Map<String, String> allParameterDetails = new HashMap<>();
        while (list.hasMoreElements()) {
            String param = list.nextElement();
            allParameterDetails.put(param, request.getParameter(param));
        }
        try {
            // save the enquiry.

            Enquiry enquiry = Enquiry.builder()
                    .name(allParameterDetails.get("name"))
                    .email(allParameterDetails.get("email"))
                    .address(allParameterDetails.get("address"))
                    .sex(allParameterDetails.get("sex"))
                    .phone(allParameterDetails.get("phone"))
                    .source(allParameterDetails.get("source"))
                    .build();
            repository.save(enquiry);

            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
            modelAndView.setViewName("Enquiry");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));
            modelAndView.setViewName("Enquiry");
        }

        return modelAndView;
    }

}

