package com.conference.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.conference.bean.SubmitBean;
import com.conference.exception.CustomValidationException;
import com.conference.model.Conference;
import com.conference.model.Track;
import com.conference.util.MainUtil;

import ch.qos.logback.core.joran.spi.ActionException;

@Controller
public class ResultController {

	@RequestMapping(value = "/postInput", method = RequestMethod.POST)
	public ModelAndView post(@Valid @ModelAttribute("submitBean") SubmitBean submitBean) throws ActionException {

		List<ArrayList<Conference>> allConferences = MainUtil.convertSubmitBeanToList(submitBean.getPostInput());

		checkInputValidation(allConferences);

		List<Track> tracks = MainUtil.scheduleConferences(allConferences);

		// We can return a model here, but I return only list!!
		ModelAndView modelAndView = new ModelAndView("showResult", "tracks", tracks);

		return modelAndView;
	}

	// For this, we can code server side validation in SubmitBean too.
	private void checkInputValidation(List<ArrayList<Conference>> allConferences) throws CustomValidationException {
		// All given conferences cannot be lightning conferences
		ArrayList<Conference> conferences = allConferences.get(0);
		if (conferences.size() == 0) {
			throw new CustomValidationException(1);
		}

		for (int i = 0; i < conferences.size(); i++) {
			if (conferences.get(i).getTime() > 60) {
				throw new CustomValidationException(2);
			}
		}
	}

}