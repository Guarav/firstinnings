package com.firstinnings.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handles the actions or operations that can be possible for the user to do.
 * This might be divided on different controllers depending on how big this file will become
 * Created by poplig on 9/7/16.
 */
@Controller
public class ActionsController {

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
     * Update member render.
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/updateMember")
    public String updateMember(ModelMap model) {

        return "UpdateMember";
    }


}
