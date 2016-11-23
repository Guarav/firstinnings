package com.firstinnings.controllers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.dto.Renew;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.repositories.RenewRepository;

/**
 * Created by poplig on 11/13/16.
 */
@Controller
public class RenewMemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RenewRepository  renewRepository;

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
    public ModelAndView renewMemberSubmit(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("RenewMember");
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
        // make a new entry in renew table.
        Renew renew = Renew.builder().amount(Integer.parseInt(allParameterDetails.get("amount_paid")))
                .membershipMonths(Integer.parseInt(allParameterDetails.get("membership_months")))
                .renewalDate(allParameterDetails.get("renewal_date")).memberId(memberId).build();

        try {
            // save the entry.
            renewRepository.save(renew);
            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
        } catch (Exception e) {
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));

        }
        return modelAndView;
    }

    /**
     * Renew member render.
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findMember")
    public @ResponseBody Map findMember(@RequestParam("medium") String medium, @RequestParam("value") String value) {

        System.out.println("in gaurav " + medium);
        Map<String, Object> response = new HashMap<>();
        if (StringUtils.equals(medium, "phone")) {

            // Search for phone
            Member member = memberRepository.findByPhone(value);
            System.out.println("member before " + member);
            if (member != null) {
                System.out.println("member found " + member);
                response.put("member", member);
            }
        } else if (StringUtils.equals(medium, "membershipId")) {

            Member member = memberRepository.findOne(value);
            if (member != null) {
                System.out.println("member found " + member);
                response.put("member", member);
            }
        } else if (StringUtils.equals(medium, "emailId")) {
            Member member = memberRepository.findByEmail(value);
            if (member != null) {
                System.out.println("member found " + member);
                response.put("member", member);
            }
        }

        return response;
    }
}
