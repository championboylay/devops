package com.devoppsbuddy.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devoppsbuddy.backend.service.EmailService;
import com.devoppsbuddy.web.domain.frontend.FeedBack;

@Controller
public class ContactController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
    /** The key which identifies the feedback payload in the Model. */
    public static final String FEEDBACK_MODEL_KEY = "feedback";

    /** The Contact Us view name. */
    private static final String CONTACT_US_VIEW_NAME = "contact/contact";

   @Autowired 
   private EmailService emailService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(ModelMap model) {
        FeedBack feedbackPojo = new FeedBack();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedBack fb) {
        emailService.sendFeedbackEmail(fb);
        return ContactController.CONTACT_US_VIEW_NAME;
    }

	
}
