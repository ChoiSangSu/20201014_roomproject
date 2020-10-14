package com.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	//login.jsp�� �̵�
		@RequestMapping(value="/",method = RequestMethod.GET)
		public String login() {
			return "main/main";
		}
		
		
		 //slider.jsp�� �̵�
		  @RequestMapping("slider") 
		  public String image() {
			  return "main/slider"; 
		}
		 
}
