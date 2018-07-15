package com.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("Greeting", "Welcome to Spring Web MVC");
		return mv;
	}
	
	// http://localhost:8080/shoppingkartFrontEnd/test?greeting=Welocme  - output will be welcome
	// http://localhost:8080/shoppingkartFrontEnd/test - output will be Hello World 
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false) String greeting) {
		if(greeting == null) {greeting = "Hello World";}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("Greeting", greeting);
		return mv;
	}*/
	
	
	// Use of @PathVariable variable - This is very helpful for SEO
	// we need to use curly braces "{}" in @RequestMapping value
	@RequestMapping(value="/test/{greeting}")
		public ModelAndView test(@PathVariable("greeting") String greeting) {
			//if(greeting == null) {greeting = "Hello World";}
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("Greeting", greeting);
			return mv;
		}
	}
