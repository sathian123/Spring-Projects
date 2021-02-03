package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//	@RequestMapping("home")
//	public String home(HttpServletRequest request) {
//		HttpSession httpSession = request.getSession();
//		httpSession.setAttribute("name", request.getParameter("name"));
//		return "home";
//	}
	
//	@RequestMapping("home")
//	public String home(String name,HttpSession httpSession) {
//		httpSession.setAttribute("name", name);
//		return "home";
//	}
	
	
//	@RequestMapping("home")
//	public ModelAndView home(@RequestParam("name1")String name) {
//		ModelAndView modelAndView=new ModelAndView();
//		modelAndView.addObject("name", name);
//		modelAndView.setViewName("home");
//		return modelAndView;
//	}
	
	
	@RequestMapping("home")
	public ModelAndView home(Alian a) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("obj", a);
		modelAndView.setViewName("home");
		return modelAndView;
	}


}
