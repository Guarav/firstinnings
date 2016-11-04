package com.firstinnings.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.firstinnings.accessor.MongoAccessor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.repositories.MemberRepository;

/**
 * This controller handles the actions or operations that can be possible for the user to do. This
 * might be divided on different controllers depending on how big this file will become Created by
 * poplig on 9/7/16.
 */
@Controller
public class ActionsController {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private MongoAccessor mongoAccessor;



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
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/renewMember")
    public String renewMember() {


        return "RenewMember";
    }

    /**
     * Handles renew member submit.
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/renewMember")
    public String renewMemberSubmit(HttpServletRequest request) {


        String memberId = request.getParameter("memberId");
        return "RenewMember";
    }



    /**
     * Renew member render.
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findMember")
    public @ResponseBody Map findMember(@RequestParam("medium") String medium, @RequestParam("value") String value) {


        System.out.println("in gaurav " + medium);
        Map<String, Object> response = new HashMap<>();
        if(StringUtils.equals(medium, "phone")) {

            // Search for phone
            Member member = repository.findByPhone(value);
            System.out.println("member before " + member);
            if(member != null) {
                System.out.println("member found " + member);
                response.put("member", member);
            }
        }

        return response;
    }

}
