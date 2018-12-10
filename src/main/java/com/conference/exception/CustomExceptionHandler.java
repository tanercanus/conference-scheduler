package com.conference.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

@Component
public class CustomExceptionHandler extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) {

		ModelAndView modelAndView = new ModelAndView("error");

		if (exception instanceof CustomValidationException) {
			CustomValidationException ex = (CustomValidationException) exception;

			String errorText = "Validation Error!!";

			// We can define these codes in a file
			if (ex.getExceptionType() == 1) {
				errorText = "All conferences cannot be lightning conferences.";
			} else if (ex.getExceptionType() == 2) {
				errorText = "Conference time cannot be greater than 60 min.";
			}

			modelAndView.addObject("errorText", errorText);
			return modelAndView;
		}

		return null;
	}

}
