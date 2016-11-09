package com.firstinnings.controllers;

import java.util.HashMap;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.firstinnings.accessor.MongoAccessor;
import com.firstinnings.dto.Member;
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
        // String fromAddress = "esha90@gmail.com";//Your Email Address//
        // String addressedTo = "esha90@gmail.com";
        // String recipients = addressedTo.trim();
        // String contentType = "text/plain";
        // String smtpHost = "smtp.gmail.com";//Your Outgoing Mailbox//
        // int smtpPort = 587;
        // String username = "esha90@gmail.com";//Your Mailbox Username//
        // String password = "#";//Your Mailbox Password//
        //
        // try
        // {
        // Properties props = System.getProperties();
        // props.put("mail.smtp.starttls.enable", "true");
        // Session session = Session.getDefaultInstance(props);
        //
        // MimeMessage message = new MimeMessage(session);
        //
        // message.setFrom(new InternetAddress(fromAddress));
        // message.setRecipients(javax.mail.Message.RecipientType.TO,
        // InternetAddress.parse(recipients, false));
        //
        // String subject = "hi";
        // message.setSubject(subject);
        // String content = "how are you";
        // message.setContent(content, contentType);
        // message.setSentDate(new Date());
        //
        // Transport transport = session.getTransport("smtp");
        // transport.connect(smtpHost, smtpPort, username, password);
        // transport.sendMessage(message, message.getAllRecipients());
        // transport.close();
        //
        // // return true;
        // } catch (MessagingException messagingException)
        // {
        // System.out.print(messagingException);
        // // return false;
        //
        // } catch (Exception e)
        // {
        // System.out.print(e);
        // // return false;
        // }

        // Properties props = new Properties();
        // props.put("mail.smtp.host", "smtp.gmail.com");
        // props.put("mail.smtp.port", "465");
        // props.put("mail.smtp.auth", "true");
        // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //
        // try {
        //
        // Authenticator auth = new SMTPAuthenticator();
        //
        // Session session = Session.getInstance(props);
        // MimeMessage msg = new MimeMessage(session);
        // msg.setSubject("Open");
        // msg.setFrom(new InternetAddress("esha90@gmail.com"));
        // msg.setRecipient(javax.mail.Message.RecipientType.TO, new
        // InternetAddress("esha90@gmail.com"));
        // msg.setText("How are you");
        // Transport.send(msg);
        // System.out.println("Mail Delivered......");
        // } catch (Exception e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }
        //
        //
        // class SMTPAuthenticator extends Authenticator{
        // public PasswordAuthentication getPasswordAuthentication(){
        // return new PasswordAuthentication("esha90@gmail.com","#");
        // }
        // }

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
            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("esha90@gmail.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "Writetous";
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
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/findMember")
    public @ResponseBody Map findMember(@RequestParam("medium") String medium, @RequestParam("value") String value) {

        System.out.println("in gaurav " + medium);
        Map<String, Object> response = new HashMap<>();
        if (StringUtils.equals(medium, "phone")) {

            // Search for phone
            Member member = repository.findByPhone(value);
            System.out.println("member before " + member);
            if (member != null) {
                System.out.println("member found " + member);
                response.put("member", member);
            }
        }

        return response;
    }

}
