package com.firstinnings.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Member;
import com.firstinnings.dto.Subscription;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.repositories.SubscriptionRepository;

/**
 * Created by poplig on 11/27/16.
 */
@Controller
public class DefaulterController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private MemberRepository       memberRepository;

    // todo : need to consider the filter option to filter out duplicate result for same member.
    @RequestMapping(method = RequestMethod.GET, value = "/defaulters")
    public ModelAndView defaulterRender() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("defaulters");

        List<Subscription> subscriptionList = subscriptionRepository.findByExpirationDateBeforeAndStatus(
                DateUtils.addDays(new Date(), 1), Member.Status.ACTIVE);

        List<Member> memberList = new ArrayList<>();

        // get the list of members using this subscription list.
        subscriptionList.stream().forEach(subscription -> {

            memberList.add(memberRepository.findOne(subscription.getMemberId()));
        });

        modelAndView.addObject("defaulters", memberList);

        return modelAndView;
    }

}
