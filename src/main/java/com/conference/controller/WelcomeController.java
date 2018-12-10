package com.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.conference.bean.SubmitBean;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("welcome", "submitBean", new SubmitBean());
	}

	@RequestMapping(value = "/postInput", method = RequestMethod.GET)
	public ModelAndView submitGet() {
		return new ModelAndView("welcome", "submitBean", new SubmitBean());
	}

}