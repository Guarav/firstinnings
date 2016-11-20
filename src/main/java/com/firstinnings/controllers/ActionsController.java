package com.firstinnings.controllers;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.accessor.MongoAccessor;
import com.firstinnings.dto.Member;
import com.firstinnings.dto.Message;
import com.firstinnings.repositories.MemberRepository;
import com.firstinnings.repositories.RenewRepository;

/**
 * This controller handles the actions or operations that can be possible for the user to do. This
 * might be divided on different controllers depending on how big this file will become Created by
 * poplig on 9/7/16.
 */
@Controller
public class ActionsController {

    @Autowired
    private MemberRepository memberRepository;

    private RenewRepository  renewRepository;

    @Autowired
    private MongoAccessor    mongoAccessor;

    /**
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updateMember")
    public String updateMember(ModelMap model) {

        return "UpdateMember";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchMember")
    public ModelAndView searchMember(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        final String phoneNumber = request.getParameter("phone");
        final String name = request.getParameter("name");

        Member member = null;
        if (StringUtils.isNotBlank(phoneNumber) && StringUtils.isNotBlank(name)) {
            modelAndView.addObject("message",
                    new Message("Please provide one of phone number or name.", Message.Status.ERROR));
        } else if (StringUtils.isBlank(phoneNumber) && StringUtils.isBlank(name)) {
            modelAndView.addObject("message", new Message("phone number and name both empty", Message.Status.ERROR));
        } else if (StringUtils.isNotBlank(phoneNumber)) {
            member = memberRepository.findByPhone(phoneNumber);
        } else {
            member = memberRepository.findByName(name);
        }

        // TODO: Need to verify whether list can come from search by Name.
        modelAndView.addObject("member", member);
        modelAndView.setViewName("UpdateMember");
        return modelAndView;
    }

    /**
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/Writetous")
    public String Writetous(ModelMap model) {

        return "Writetous";
    }

    /**
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/Writetous")
    public String Writetous1(ModelMap model) {

        final String username = "abeygaurav@gmail.com";
        final String password = "##";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {

            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("esha90@gmail.com"));
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("abeygaurav@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "Writetous";
    }

}
