package com.info.JSPH2.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;

import com.info.JSPH2.service.UserService;

@Controller
@RequestMapping({"/","/index"})
public class HomeController {

	@Autowired
	private UserService userService;
	
   @RequestMapping(method=RequestMethod.GET)
	public String index(Model uiModel){
		
		uiModel.addAttribute("users", userService.findAll());
		
		return "home";
		
	}
	
	
}
