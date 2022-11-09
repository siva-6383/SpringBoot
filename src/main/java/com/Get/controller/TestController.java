package com.Get.controller;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Get.service.seriviceclass;

@RestController
@RequestMapping("/api/")

public class TestController {

	@Autowired
	seriviceclass objseriviceclass;
	@Value("${userfilepath}")
	private String filePath;

	@RequestMapping(value = "testAPI", method = RequestMethod.GET)
	public ResponseEntity<?> testApi(@RequestParam Map<String,String> request)
			throws Exception {
		int result = 0;
		String operation=request.get("operation").toString();
		int a=Integer.parseInt(request.get("a").toString());
		int b=Integer.parseInt(request.get("b").toString());
		
		
		switch (operation) {

		case "add":
			result = objseriviceclass.add(a, b);
			break;
		case "sub":
			result = objseriviceclass.sub(a, b);
			break;
		case "mul":
			result = objseriviceclass.mul(a, b);
			break;
		case "div":
			result = objseriviceclass.div(a, b);
			break;
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<?> user(@RequestParam Map<String, String> input) throws Exception {
		System.out.println(filePath);
		Properties pro = new Properties();
		try {

			FileInputStream file = new FileInputStream(filePath);
			pro.load(file);
			System.out.println(pro);
		} catch (Exception e) {
			System.out.println("Error:---------------------------"+pro);			
			System.out.println(e);
		}

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

}