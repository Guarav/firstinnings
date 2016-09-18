package com.firstinnings.controllers;

import com.firstinnings.dto.Member;
import com.firstinnings.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This controller handles the actions or operations that can be possible for the user to do.
 * This might be divided on different controllers depending on how big this file will become
 * Created by poplig on 9/7/16.
 */
@Controller
public class ActionsController {

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
    public String addAMemberSubmit(HttpServletRequest request) {

        Enumeration<String> list = request.getParameterNames();
        Map<String, String> allParameterDetails = new HashMap<>();
        while (list.hasMoreElements()) {
            String param = list.nextElement();
            allParameterDetails.put(param, request.getParameter(param));
        }
        System.out.println("add a member " + allParameterDetails) ;
        repository.save(new Member(allParameterDetails));


        return "AddMember";
    }

    /**
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updateMember")
    public String updateMember(ModelMap model) {

        return "UpdateMember";
    }

    /**
     * Renew member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/renewMember")
    public String renewMember(ModelMap model) {

        return "RenewMember";
    }


}
