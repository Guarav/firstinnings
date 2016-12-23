package com.firstinnings.controllers;

import java.util.HashMap;
import java.util.Map;

import com.firstinnings.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstinnings.dto.Member;
import com.firstinnings.repositories.MemberRepository;

/**
 * Created by poplig on 12/23/16. Find member controller.
 */
@Controller
public class FindMemberController {

    @Autowired
    private DateUtility dateUtility;

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Find member call.
     * @param medium
     * @param value
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findMember")
    public @ResponseBody Map findMember(@RequestParam("medium") String medium, @RequestParam("value") String value) {

        Map<String, Object> response = new HashMap<>();
        Member member = null;
        switch (medium) {
            case "phone":
                member = memberRepository.findByPhone(value);

                break;
            case "membershipId":
                member = memberRepository.findOne(value);
                break;

            case "emailId":
                member = memberRepository.findByEmail(value);
                break;

        }


        if (member != null) {
            response.put("member", member);
        }

        return response;
    }
}
