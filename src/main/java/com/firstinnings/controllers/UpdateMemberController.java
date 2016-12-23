package com.firstinnings.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.utility.MemberUtility;

/**
 * Created by poplig on 11/23/16.
 */
@Controller
public class UpdateMemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberUtility    memberUtility;

    /**
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updateMember")
    public String updateMemberRender(ModelMap model) {

        return "UpdateMember";
    }

    /**
     * Update member submit.
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/updateMember")
    public ModelAndView updateMemberSubmit(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("UpdateMember");
        String memberId = request.getParameter("memberId");

        // Find the details of this member.
        if (StringUtils.isBlank(memberId)) {
            return modelAndView;
        }

        Member member = memberRepository.findOne(memberId);

        if (member == null) {
            return modelAndView;
        }

        Enumeration<String> list = request.getParameterNames();
        Map<String, String> allParameterDetails = new HashMap<>();
        while (list.hasMoreElements()) {
            String param = list.nextElement();
            allParameterDetails.put(param, request.getParameter(param));
        }

        try {
            Member updatedMember = memberUtility.prepareMemberFromParams(allParameterDetails);
            // save the entry.
            updatedMember.setMemberId(member.getMemberId());
            memberRepository.save(updatedMember);
            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
        } catch (Exception e) {
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));

        }
        return modelAndView;

    }

}
