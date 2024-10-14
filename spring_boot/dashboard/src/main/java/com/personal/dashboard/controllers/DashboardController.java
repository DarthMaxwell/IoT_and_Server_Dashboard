package com.personal.dashboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/")
	public String showDashboard() {
		// If logged in then show dashboard else
		
		// add rediect later
		return "redirect:login";
	}
}
