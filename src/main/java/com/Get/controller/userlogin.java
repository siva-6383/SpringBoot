package com.Get.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Get.service.Classservice;

@RestController
@RequestMapping("/login/")
public class userlogin {
	@Autowired
	 Classservice service;
	
     String result="";
	@RequestMapping(value="userlogin",method=RequestMethod.GET,produces="application/json")
	
	public String userlogin(@RequestParam String userName,@RequestParam String Password) {
		try {
			result=service.userlogin(userName,Password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

}
