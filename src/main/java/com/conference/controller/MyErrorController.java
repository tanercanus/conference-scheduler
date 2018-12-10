package com.conference.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError() {

		// Can be use log4j or sth. like
		System.err.println("Server Error!!!!");

		ModelAndView modelAndView = new ModelAndView("error");

		return modelAndView;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
