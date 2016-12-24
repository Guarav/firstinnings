package com.firstinnings.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firstinnings.dto.Subscription;
import com.firstinnings.repositories.SubscriptionRepository;

/**
 * Controller for getting revenue related information.
 */
@Controller
public class RevenueController {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /**
     * GetRevenue render.
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getRevenue")
    public String getRevenue() {
        return "GetRevenue";
    }

    /**
     * Get the revenue.
     * @return model view.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getRevenue")
    public ModelAndView getRevenueBy(@ModelAttribute("revenueBy") String revenueBy) throws Exception {
        Date date = null;
        switch (revenueBy) {
            case "Monthly":
                date = DateUtils.addMonths(new Date(), -1);
                break;
            case "Weekly":
                date = DateUtils.addWeeks(new Date(), -1);
                break;
            case "Yearly":
                date = DateUtils.addYears(new Date(), -1);
                break;
            default:
                break;
        }

        List<Subscription> subscriptions = subscriptionRepository.findBySubscriptionDateAfter(date);
        long totalRevenue = subscriptions.stream().mapToLong(Subscription::getAmount).sum();

        return new ModelAndView("GetRevenue",
                Collections.singletonMap("totalRevenue", totalRevenue));
    }
}
