package com.personal.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping
	public String checkLogin() {
		// check if password valid reterect to dashboard
		
		// else redirect back to login page
		return "rederect:login";
	}
}