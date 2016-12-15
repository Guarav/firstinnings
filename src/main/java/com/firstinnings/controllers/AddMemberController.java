package com.firstinnings.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.dto.Subscription;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.repositories.SubscriptionRepository;

/**
 * This controller handles the addition of member task.
 */
@Controller
public class AddMemberController {

    @Autowired
    private MemberRepository       memberRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

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
            // save the member details.
            Member member = new Member(allParameterDetails);
            memberRepository.save(member);

            // update the subscription details.
            int months = Integer.parseInt(allParameterDetails.get("membership_months"));
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date subscriptionDate = dateFormat.parse(allParameterDetails.get("membership_date"));
            Subscription subscription = Subscription.builder()
                    .amount(Integer.parseInt(allParameterDetails.get("amount_paid"))).membershipMonths(months)
                    .expirationDate(DateUtils.addMonths(subscriptionDate, months))
                    .place(allParameterDetails.get("place")).currentDate(new Date()).subscriptionDate(subscriptionDate)
                    .status(Member.Status.ACTIVE)
                    .memberId(member.getMemberId()).build();
            subscriptionRepository.save(subscription);

            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
            modelAndView.setViewName("AddMember");
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));
            modelAndView.setViewName("AddMember");
        }

        return modelAndView;
    }

}
