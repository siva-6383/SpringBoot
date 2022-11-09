package com.Get.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Classservice {
   String message="";
   @Value("${user.userName}")
   private String userNames;
   @Value("${user.userPass}")
    private String Passwords;
   
	public String userlogin(String userName,String Password)throws Exception {
		try {
		if(userName!=null && Password!=null) {
			if(userName.equals(userNames)) {
			if(Password.equals(Passwords)) {
				message="you have sucessfylly logined";
		
				
			 }
			  else {
				message="incorrect the password";
			  }
			}
		   else{
				message="Invalid user name";
			}
			}
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return message; 
		
	}
}
