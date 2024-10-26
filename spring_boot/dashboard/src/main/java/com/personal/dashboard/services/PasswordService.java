package com.personal.dashboard.services;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
	/* You can make hash and salt for a password but then you need to have it connected to
	* a database and because its only accessible in a private network no need
	*/
	private final String defualt = "admin";
	
	public boolean checkLogin(String username, String password) {
		return username.equals(defualt) && password.equals(defualt);
	}
}
