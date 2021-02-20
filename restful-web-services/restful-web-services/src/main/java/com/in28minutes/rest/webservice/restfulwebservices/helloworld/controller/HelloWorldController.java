package com.in28minutes.rest.webservice.restfulwebservices.helloworld.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservice.restfulwebservices.helloworld.bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "hello-world-internalized")
	public String helloWorldInternalized(@RequestHeader(name = "accept-language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.messages", null, locale);
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping(path = "hello-world/path-variable/{name}")
	public HelloWorldBean helloWorlPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}

}
