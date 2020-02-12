package com.arbtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Send RequestHeader as AcceptLanguage = EN or FR & hit the API: localhost:8888/helloWorld-internationalized
	 * @param locale
	 * @return
	 */
	@GetMapping(value = "/helloWorld-internationalized")
	public String helloWorld() {
		return messageSource.getMessage("good-morning-message", null, LocaleContextHolder.getLocale());
	}
}
