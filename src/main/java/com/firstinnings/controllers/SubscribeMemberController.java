package com.firstinnings.controllers;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.dto.Subscription;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.repositories.SubscriptionRepository;
import com.firstinnings.utility.DateUtility;

/**
 * Created by poplig on 11/13/16.
 */
@Controller
public class SubscribeMemberController {

    @Autowired
    private MemberRepository       memberRepository;

    @Autowired
    private DateUtility            dateUtility;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /**
     * Subscription member render.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/subscribeMember")
    public String renewMember() {

        return "SubscribeMember";
    }

    /**
     * Handles renew member submit.
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.POST, value = "/subscribeMember")
    public ModelAndView renewMemberSubmit(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SubscribeMember");
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

            // make the previous active subscription entry of this user as inactive first for ease
            // in query.
            List<Subscription> existingActiveSubscriptions = subscriptionRepository.findByStatusAndMemberId(
                    Member.Status.ACTIVE, memberId);

            System.out.println("poplig " + existingActiveSubscriptions);

            if (CollectionUtils.isNotEmpty(existingActiveSubscriptions)) {

                // Ideally the length of this list should be 1, iterating all the elements to make
                // sure we cover all in
                // case some got left.
                existingActiveSubscriptions.forEach(subscription -> {
                    subscription.setStatus(Member.Status.INACTIVE);
                    subscriptionRepository.save(subscription);
                });
            }

            // make a new entry in subscription table.
            int months = Integer.parseInt(allParameterDetails.get("membership_months"));
            Date subscriptionDate = dateUtility.convertToDate(allParameterDetails.get("subscription_date"));
            Subscription subscription = Subscription.builder()
                    .amount(Integer.parseInt(allParameterDetails.get("amount_paid"))).membershipMonths(months)
                    .expirationDate(DateUtils.addMonths(subscriptionDate, months))
                    .place(allParameterDetails.get("place")).subscriptionDate(subscriptionDate)
                    .status(Member.Status.ACTIVE).memberId(member.getMemberId()).build();
            // save the entry.
            subscriptionRepository.insert(subscription);
            modelAndView.addObject("message", new Message("The details have been successfully added.",
                    Message.Status.SUCCESS));
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("message", new Message("The details could not be saved. Please try again.",
                    Message.Status.ERROR));

        }
        return modelAndView;
    }
}
